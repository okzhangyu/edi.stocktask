package org.edi.stocktask.service;
import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.jboss.logging.Param;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/19
 */
@Path("/v1")
public class StockTaskService implements IStockTaskService{

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public IResult<IStockTask> fetchStockTask() {
        IResult<IStockTask> result = new Result<IStockTask>();
        result.setCode("0");
        result.setMessage("ok");
        List<IStockTask> stockTasks = new ArrayList<IStockTask>() ;
        IStockTask stockTask = new StockTask();
        stockTask.setObjectCode("11");
        stockTask.setObjectKey(12);
        stockTasks.add(stockTask);
        return result;
    }

    @GET
    @Override
    @Path("/stocktask")
    @Produces("text/plain")
    public IResult<IStockTask> fetchStockTask(@Param Integer objectKey) {
        return null;
    }

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocktasks")
    public IResult<?> saveStockTask(List<IStockTask> stockTasks) {
        return null;
    }

    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){
        return "hello";
    }


}
