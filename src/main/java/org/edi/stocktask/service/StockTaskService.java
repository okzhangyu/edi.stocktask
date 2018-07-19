package org.edi.stocktask.service;

import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
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
    public Result<StockTask> fetchStockTask(@QueryParam(ServicePath.TOKEN_NAMER)String token){
        Result result = new Result();
        try{
            List<StockTask> stockTasks = boRepositoryStockTask.fetchStockTask();
            result = new Result<StockTask>(ResultCode.OK,ResultDescription.OK,stockTasks);
        }catch(Exception e){
            e.printStackTrace();
            result = new Result(ResultCode.FAIL,"failed:"+e.getCause(),null);
        }
     return result;
    }



    @POST
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public Result saveStockTask(List<IStockTask> stockTasks,@QueryParam(ServicePath.TOKEN_NAMER)String token) {
        Result result = new Result("0","ok",null);
        return result;
    }

    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){ return "hello"; }


}