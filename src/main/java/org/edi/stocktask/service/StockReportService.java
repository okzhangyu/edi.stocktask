package org.edi.stocktask.service;


import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.repository.IBOReposirotyStockReport;
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

    @Autowired
    private IBOReposirotyStockReport iBOReposirotyStockReport;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    public Result<StockReport> fetchStockReport(@QueryParam("token")String token) {
        List<StockReport> StockReports = iBOReposirotyStockReport.fetchStockReport();
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = iBOReposirotyStockReport.fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        Result result = new Result("0","ok",StockReports);
        return result;
    }




    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    public Result SaveStockReport(@QueryParam("token")String token,List<StockReport> stockReports) {
        Result result = new Result();
        if(stockReports.size()<1){
            result = new Result("1","传递数据为空，保存失败!",null);
        }
        try {
            for(int i=0;i<stockReports.size();i++){
                StockReport stockReport = stockReports.get(i);
                iBOReposirotyStockReport.saveStockReport(stockReport);
                for (int j=0;j<stockReports.get(i).getStockReportItems().size();j++){
                    StockReportItem stockReportItem = stockReports.get(i).getStockReportItems().get(j);
                    stockReportItem.setLineId(j+1);
                    iBOReposirotyStockReport.saveStockReportItem(stockReportItem);
                }
            }
            result = new Result("0","保存成功!",null);
        }catch (Exception e){
            e.printStackTrace();
            result = new Result("1","服务器资源错误,保存失败!",null);
        }
        return result;
    }

}
