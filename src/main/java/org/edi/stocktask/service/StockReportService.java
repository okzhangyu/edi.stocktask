package org.edi.stocktask.service;


import org.apache.log4j.Logger;
import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.repository.BOReposirotyStockReport;
import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/31
 */
@Path("/v1")
@Transactional
public class StockReportService implements  IStockReportService{
    private static Logger log = Logger.getLogger(StockReportService.class);

    @Autowired
    private BOReposirotyStockReport boReposirotyStockReport;


    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stockreports")
    //查询库存任务汇报
    public Result<StockReport> fetchStockReport(@QueryParam("token")String token) {
        List<StockReport> StockReports = boReposirotyStockReport.fetchStockReport();
        Result result = new Result("0","ok",StockReports);
        return result;
    }





    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    //保存库存任务汇报
    public Result saveStockReport(@QueryParam("token")String token,List<StockReport> stockReports){
        log.info("parameter info:"+stockReports);
        Result result = new Result();
            try {
                for (int i = 0; i < stockReports.size(); i++) {
                    StockReport stockReport = stockReports.get(i);
                    boReposirotyStockReport.saveStockReport(stockReport);
                    for (int j = 0; j < stockReports.get(i).getStockReportItems().size();j++) {
                        StockReportItem stockReportItem = stockReports.get(i).getStockReportItems().get(j);
                        stockReportItem.setLineId(j + 1);
                        boReposirotyStockReport.saveStockReportItem(stockReportItem);
                    }
                }
                result = new Result("0", "ok!", null);
            } catch (Exception e) {
                e.printStackTrace();
                result = new Result("1", "failed!", null);
            }
        return result;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreportstest")
    //用于测试参数类型
    public Result saveStockReportTest(@QueryParam("token")String token,String stockReports){
        log.info("parameter info:"+stockReports);
        Result result = new Result("0", "ok!", null);
        return result;
    }

}
