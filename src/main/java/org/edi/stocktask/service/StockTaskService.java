package org.edi.stocktask.service;
import org.apache.log4j.Logger;
import org.edi.stocktask.bo.stocktask.IStockReport;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Fancy
 * @date 2018/5/19
 */
@Path("v1")
public class StockTaskService implements IStockReportService{

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stockreports")
    public String fetchStockReport() {
        return null;
    }

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stockreports")
    public String SaveStockReport(IStockReport stockReport) {
        return null;
    }

}
