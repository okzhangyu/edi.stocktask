package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;
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
public class StockTaskService implements IStockTaskService{

    @Autowired
    private IBORepositoryStockTask iBORepositoryStockTask;

    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stocktasks")
    //查询库存任务
    public Result<StockTask> fetchStockTask(@QueryParam("token")String token) {
        List<StockTask> stockTasks = iBORepositoryStockTask.fetchStockTask() ;
        Result<StockTask> result = new Result<StockTask>("0","ok",stockTasks);
        return result;
    }


    @GET
    @Path("/stocktaskitems")
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    //查询库存任务明细
    public Result<StockTaskItem> fetchStockTaskItem(@QueryParam("objectKey")Integer objectKey,@QueryParam("token")String token) {
        List<StockTaskItem> stockTaskItems = iBORepositoryStockTask.fetchStockTaskItem(objectKey) ;
        Result<StockTaskItem> result = new Result<StockTaskItem>("0","ok",stockTaskItems);
        return result;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public Result<?> saveStockTask(List<IStockTask> stockTasks,@QueryParam("token")String token) {
        return null;
    }

    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){
        return "hello";
    }


}
