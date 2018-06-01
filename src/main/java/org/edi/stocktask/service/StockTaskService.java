package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.jboss.logging.Param;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/19
 */
@Path("/v1")
public class StockTaskService {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public Result<IStockTask> fetchStockTask(@QueryParam("token")String token) {
        Result<IStockTask> result = new Result<IStockTask>();
        result.setCode("0");
        result.setMessage("ok");
        List<IStockTask> stockTasks = new ArrayList<IStockTask>() ;
        IStockTask stockTask = new StockTask();
        stockTask.setObjectCode("11");
        stockTask.setObjectKey(12);
        stockTasks.add(stockTask);
        result.setData(stockTasks);
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
