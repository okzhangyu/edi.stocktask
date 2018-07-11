package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.edi.stocktask.repository.IBORepositoryStockTask;
import org.edi.stocktask.util.TokenVerification;
import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/19
 */
@Path("/v1")
@Transactional
public class StockTaskService implements IStockTaskService{

    @Autowired
    private IBORepositoryStockTask boRepositoryStockTask;


    @Autowired
    private StockTaskMapper stockTaskMapper;

    @Autowired
    private TokenVerification tokenVerification;


    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stocktasks")
    //查询库存任务
    public Result<StockTask> fetchStockTask(@QueryParam("token")String token){
        Result result = new Result();
        String msg = tokenVerification.verification(token);
        if(msg.equals("ok")){
            List<StockTask> stockTasks = boRepositoryStockTask.fetchStockTask();
            result = new Result<StockTask>("0","ok",stockTasks);
        }else{
            result = new Result("1","failed:"+msg,null);
        }
     return result;
    }



    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stocktaskitems")
    //查询库存任务
    public Result<StockTaskItem> fetchStockTaskItem(@QueryParam("token")String token){
        Result result = new Result();
        String msg = tokenVerification.verification(token);
        if(msg.equals("ok")){
            List<StockTaskItem> stockTaskItems =stockTaskMapper.fetchAllStockTaskItem();
            result = new Result<StockTaskItem>("0","ok",stockTaskItems);
        }else{
            result = new Result("1","failed:"+msg,null);
        }
        return result;
    }


    @POST
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public Result saveStockTask(List<IStockTask> stockTasks,@QueryParam("token")String token) {
        Result result = new Result("0","ok",null);
        return result;
    }

    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){ return "hello"; }


}