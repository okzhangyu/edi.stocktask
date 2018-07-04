package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBOReposirotyStockReport {
    List<StockReport> fetchStockReport();
    List<StockReport> fetchStockReportByEntry(Integer docEntry);
    void saveStockReport(StockReport stockReports);
    void saveStockReportItem(StockReportItem stockReportItem) ;
}
