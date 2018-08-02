package org.edi.stocktask.service;

import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.material.Material;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.edi.stocktask.repository.IBORepositoryStockTask;
import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/19
 */
@Path("/v1")
@UserRequest
public class StockTaskService implements IStockTaskService{

    @Autowired
    private IBORepositoryStockTask boRepositoryStockTask;

    @Autowired
    private StockTaskMapper stockTaskMapper;

    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stocktasks")
    /**
     * 查询库存任务
     */
    public Result<IStockTask> fetchStockTask(@QueryParam(ServicePath.TOKEN_NAMER)String token,@QueryParam(StockTaskServicePath.SERVICE_SEARCH_PARAMETER)String param){
        Result result = new Result();
        try{
            List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTask(param);
            result = new Result<>(ResultCode.OK,ResultDescription.OK,stockTasks);
        }catch(Exception e){
            result = new Result(ResultCode.FAIL,e);
        }
     return result;
    }


    /**
     * 条件查询库存任务
     */
    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stocktasksterm")
    public Result<IStockTask> fetchStockTaskByCondition(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                       @QueryParam(StockTaskServicePath.SERVICE_DOCENTRY)int docEntry,
                                                       @QueryParam(StockTaskServicePath.SERVICE_DOCTYPE)String docType){
        Result result;
        try{
            List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTaskByCondition(docEntry,docType);
            result = new Result<>(ResultCode.OK,ResultDescription.OK,stockTasks);
        }catch(Exception e){
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
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stocktaks/materials")
    @Override
    public Result<IMaterial> fetchStockTaskMaterial(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                    @QueryParam(StockTaskServicePath.SERVICE_DOCENTRY)Integer docEntry) {
        Result result;
        try{
            List<IMaterial> materials = boRepositoryStockTask.fetchStockTaskMaterials(docEntry);
            result = new Result<>(ResultCode.OK,ResultDescription.OK,materials);
        }catch(Exception e){
            result = new Result(ResultCode.FAIL,e);
        }
        return result;
    }

}