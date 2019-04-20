package org.edi.stocktask.mapper;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.bo.stockreport.StockReportMaterialItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StockReportMapper {
    StockReport fetchStockReportByEntry(Integer docEntry);
    List<StockReportItem> fetchStockReportItem(Integer docEntry);
    void saveStockReport(StockReport stockReports);
    void saveStockReportItem(StockReportItem stockReportItem);
    void deleteStockReport(Integer docEntry);
    void deleteStockReportItem(Integer docEntry);
    List<StockReport> fetchStockReportByCondition(Map<String,String> stockReportCondition);
    List<StockReport> fetchStockReportFuzzyByPage(HashMap<String,Object> params);
    void updateStockReport(StockReport stockReport);
    void updateStockReportItem(StockReportItem stockRepotItem);
    int fetchSequenceOfDocEntry();
    List<StockReport> fetchUnSyncStockReport();
    void updateStockReportDocStatus(StockReport stockReport);

    List<StockReportMaterialItem> fetchStockReportMaterialItem(Integer docEntry,Integer lineId);

    void saveStockReportMaterialItem(StockReportMaterialItem stockReportMaterialItem);

    void deleteStockReportMaterialItem(int docEntry);

    void updateIsDelete(Integer docEntry);

}
