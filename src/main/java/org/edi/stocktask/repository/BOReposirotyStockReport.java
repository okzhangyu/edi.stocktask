package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.mapper.StockReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */

@Transactional
@Component(value="boReposirotyStockReport")
public class BOReposirotyStockReport implements IBOReposirotyStockReport{

    @Autowired
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
    /**
     * 保存库存任务汇报
     */
    public void saveStockReport(StockReport stockReport){
            stockReportMapper.saveStockReport(stockReport);
    }


    /**
     * 保存库存任务汇报明细
     * @param stockReportItem
     */
    public void saveStockReportItem(StockReportItem stockReportItem){
            stockReportMapper.saveStockReportItem(stockReportItem);
    }

    @Override
    /**
     * 模糊查询
     */
    public List<StockReport> fetchStockReportFuzzy(String value) {
        return null;
    }


}