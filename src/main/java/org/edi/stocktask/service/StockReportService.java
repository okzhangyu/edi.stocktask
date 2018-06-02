package org.edi.stocktask.service;


import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.IStockReport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/31
 */
@Path("/v1")
public class StockReportService implements  IStockReportService{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    public Result<IStockReport> fetchStockReport(@QueryParam("token")String token) {
        return null;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    public Result SaveStockReport(List<IStockReport> stockReports,@QueryParam("token")String token) {
        return null;
    }

}
