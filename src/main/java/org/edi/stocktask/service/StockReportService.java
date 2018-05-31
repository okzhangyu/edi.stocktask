package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.stocktask.bo.stockreport.IStockReport;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/31
 */
@Path("/v1")
public class StockReportService implements IStockReportService{
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    public IResult<IStockReport> fetchStockReport() {
        return null;
    }

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    public IResult SaveStockReport(List<IStockReport> stockReports) {
        return null;
    }

}
