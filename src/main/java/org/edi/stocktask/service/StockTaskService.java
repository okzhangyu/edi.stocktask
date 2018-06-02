package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.repository.IBORepositoryStockTask;
import org.jboss.logging.Param;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public Result<StockTask> fetchStockTask(@QueryParam("token")String token) {
        List<StockTask> stockTasks = iBORepositoryStockTask.fetchStockTask() ;
        Result<StockTask> result = new Result<StockTask>("0","ok",stockTasks);
        return result;
    }


    @GET
    @Path("/stocktask")
    @Produces("text/plain")
    public Result<IStockTask> fetchStockTask(@Param Integer objectKey,@QueryParam("token")String token) {
        return null;
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
