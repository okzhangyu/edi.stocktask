package org.edi.stocktask.mapper;

import org.edi.freamwork.transcation.TranscationResult;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StockReportMapper {
    List<StockReport> fetchStockReport();
    List<StockReport> fetchStockReportByPage(int beginIndex,int limit);
    StockReport fetchStockReportByEntry(Integer docEntry);
    List<StockReportItem> fetchStockReportItem(Integer docEntry);
    void saveStockReport(StockReport stockReports);
    void saveStockReportItem(StockReportItem stockReportItem);
    void deleteStockReport(Integer docEntry);
    void deleteStockReportItem(Integer docEntry);
    List<StockReport> fetchStockReportByCondition(Map<String,String> stockReportCondition);
    List<StockReport> fetchStockReportFuzzy(String value);
    List<StockReport> fetchStockReportFuzzyByPage(HashMap<String,Object> params);
    void updateStockReport(StockReport stockReport);
    void updateStockReportItem(StockReportItem stockRepotItem);
    int fetchSequenceOfDocEntry();
    List<StockReport> fetchUnSyncStockReport();
    void updateStockReportDocStatus(StockReport stockReport);
}
