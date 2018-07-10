package org.edi.stocktask.mapper;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;

import java.util.List;

public interface StockReportMapper {
    List<StockReport> fetchStockReport();
    StockReport fetchStockReportByEntry(Integer docEntry);
    List<StockReportItem> fetchStockReportItem(Integer docEntry);
    void saveStockReport(StockReport stockReports);
    void saveStockReportItem(StockReportItem stockReportItem);
    void deleteStockReport(Integer docEntry);
    void deleteStockReportItem(Integer docEntry);
    StockReport fetchStockReport(String companyName, String baseDocumentType, String baseDocumentDocEntry);
}
