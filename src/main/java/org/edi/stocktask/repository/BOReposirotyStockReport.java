package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */

@Transactional
@Component("BOReposirotyStockReport")
public class BOReposirotyStockReport implements IBOReposirotyStockReport{

    @Resource
    private IBOReposirotyStockReport iBOReposirotyStockReport;


    //查询库存任务汇报
    public List<StockReport> fetchStockReport(){
        List<StockReport> StockReports = iBOReposirotyStockReport.fetchStockReport();
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = iBOReposirotyStockReport.fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        return StockReports;
    }


    //根据DOCENTRY查询库存任务汇报
    public List<StockReport> fetchStockReportByEntry(Integer docEntry){
        List<StockReport> StockReports = iBOReposirotyStockReport.fetchStockReportByEntry(docEntry);
        return StockReports;
    }


    //根据DOCENTRY查询库存任务汇报明细
    public List<StockReportItem> fetchStockReportItem(Integer docEntry){
        List<StockReportItem> StockReportItems = iBOReposirotyStockReport.fetchStockReportItem(docEntry);
        return StockReportItems;
    }



   //保存库存任务汇报
    public void saveStockReport(StockReport stockReport){
        try {
            iBOReposirotyStockReport.saveStockReport(stockReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //保存库存任务汇报明细
    public void saveStockReportItem(StockReportItem stockReportItem){
        try {
            iBOReposirotyStockReport.saveStockReportItem(stockReportItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
