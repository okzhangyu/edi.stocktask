package org.edi.stocktask.service;

import org.apache.log4j.Logger;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.mapper.StockTaskMapper;
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
    private static Logger log = Logger.getLogger(StockTaskService.class);


    @Autowired
    private IBORepositoryStockTask boRepositoryStockTask;

    @Autowired
    private StockTaskMapper stockTaskMapper;



    /**
     * 查询库存任务
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktask")
    @Override
    public Result<IStockTask> fetchStockTask(@QueryParam(ServicePath.TOKEN_NAMER)String token,@QueryParam(StockTaskServicePath.SERVICE_SEARCH_PARAMETER)String param,
                                             @QueryParam(ServicePath.SERVICE_BEGININDEX)int beginIndex,@QueryParam(ServicePath.SERVICE_LIMIT)int limit){


        Result result = new Result();
        try{
            limit = PageVerification.limitCalculation(beginIndex,limit);
            List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTask(param,beginIndex==0?1:beginIndex,limit);
            if (stockTasks.size()==0){
                result = new Result<>(ResultCode.OK,ResultDescription.TASK_IS_EMPTY,stockTasks);
            }else {
                result = new Result<>(ResultCode.OK,ResultDescription.OK,stockTasks);
            }

        }catch(Exception e){
            log.warn(e);
            result = new Result(ResultCode.FAIL,e);
        }
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
        Result result;
        try{
            List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTaskByCondition(docEntry,docType);
            if(stockTasks.size()==0){
                result = new Result<>(ResultCode.OK,ResultDescription.REPORTTASK_IS_EMPTY,stockTasks);
            }else {
                result = new Result<>(ResultCode.OK, ResultDescription.OK, stockTasks);
            }
        }catch(Exception e){
            log.warn(e);
            result = new Result(ResultCode.FAIL,e);
        }
        return result;
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
        Result result;
        try{
            List<IMaterial> materials = boRepositoryStockTask.fetchStockTaskMaterials(docEntry);
            result = new Result<>(ResultCode.OK,ResultDescription.OK,materials);
        }catch(Exception e){
            log.warn(e);
            result = new Result(ResultCode.FAIL,e);
        }
        return result;
    }

}