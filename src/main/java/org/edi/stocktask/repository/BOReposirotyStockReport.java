package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.edi.stocktask.mapper.StockReportMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */

@Transactional
@Component("BOReposirotyStockReport")
public class BOReposirotyStockReport implements IBOReposirotyStockReport{

    @Resource
    private StockReportMapper stockReportMapper;


    @Override
    //查询库存任务汇报
    public List<StockReport> fetchStockReport(){
        List<StockReport> StockReports = stockReportMapper.fetchStockReport();
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        return StockReports;
    }


    @Override
    //根据DOCENTRY查询库存任务汇报
    public List<StockReport> fetchStockReportByEntry(Integer docEntry){
        List<StockReport> StockReports = stockReportMapper.fetchStockReportByEntry(docEntry);
        return StockReports;
    }



    @Override
    //保存库存任务汇报
    public void saveStockReport(StockReport stockReport){
        try {
            stockReportMapper.saveStockReport(stockReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}