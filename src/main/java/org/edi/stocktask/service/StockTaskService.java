package org.edi.stocktask.service;

import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.freamwork.log.LoggerUtils;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.repository.IBORepositoryStockTask;
import org.edi.stocktask.util.PageVerification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/19
 */
@Path("/v1")
@UserRequest
public class StockTaskService implements IStockTaskService{
    org.slf4j.Logger logger = LoggerUtils.Logger(StockTaskData.APPENDER_NAME);

    @Autowired
    private IBORepositoryStockTask boRepositoryStockTask;

    /**
     * 查询库存任务
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktask")
    @Override
    public Result<IStockTask> fetchStockTask(@QueryParam(ServicePath.TOKEN_NAMER)String token
            ,@QueryParam(StockTaskServicePath.SERVICE_SEARCH_PARAMETER)String param
            ,@QueryParam(ServicePath.SERVICE_BEGININDEX)int beginIndex
            ,@QueryParam(ServicePath.SERVICE_LIMIT)int limit
            ,@QueryParam(ServicePath.SERVICE_DOCSTATUS) List<String> docStatus
            ,@QueryParam(ServicePath.SERVICE_TRANSTYPE) List<String> transactionType){
        Result<IStockTask> result ;
        try{
            limit = PageVerification.limitCalculation(beginIndex,limit);
            List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTask(token, param,beginIndex==0?1:beginIndex,limit,docStatus,transactionType);
            if (stockTasks.size()==0){
                result = new Result<>(ResultCode.SUCCESS, StockOpResultDescription.TASK_IS_EMPTY,stockTasks);
            }else {
                result = new Result<>(ResultCode.SUCCESS,ResultDescription.OK,stockTasks);
            }
        }catch (BusinessException e){
            result = new Result(e);
        }catch (DBException e){
            result = new Result(e);
        }catch(Exception e){
            result = new Result(ResultCode.FAIL,e);
        }
        logger.info(StockTaskData.STOCKTASK_FETCH_RETURN_INFO + result.toString());
        return result;
    }



    /**
     * 条件查询库存任务
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktaskterm")
    public Result<IStockTask> fetchStockTaskByCondition(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                       @QueryParam(StockTaskServicePath.SERVICE_DOCENTRY)int docEntry,
                                                       @QueryParam(StockTaskServicePath.SERVICE_DOCTYPE)String docType){
        try{
            List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTaskByCondition(docEntry,docType);
            if(stockTasks.size()==0){
                return new Result<>(ResultCode.SUCCESS,StockOpResultDescription.REPORTTASK_IS_EMPTY,stockTasks);
            }else {
                return new Result<>(ResultCode.SUCCESS, ResultDescription.OK, stockTasks);
            }
        }catch (BusinessException e){
            return new Result(e);
        }catch (DBException e){
            return new Result(e);
        }catch(Exception e){
            return new Result(ResultCode.FAIL,e);
        }
    }

    /**
     * 获取单据的物料信息
     *
     * @param docEntry
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktask/materials")
    @Override
    public Result<IMaterial> fetchStockTaskMaterial(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                    @QueryParam(StockTaskServicePath.SERVICE_DOCENTRY)Integer docEntry) {
        try{
            List<IMaterial> materials = boRepositoryStockTask.fetchStockTaskMaterials(docEntry);
            return new Result<>(ResultCode.SUCCESS,ResultDescription.OK,materials);
        }catch (BusinessException e){
            return new Result(e);
        }catch (DBException e){
            return new Result(e);
        }catch(Exception e){
            return new Result(ResultCode.FAIL,e);
        }
    }

}