package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBOReposirotyStockReport {

    /**
     * 查询任务汇报清单
     * @return
     */
    List<StockReport> fetchStockReport();


    List<StockReport> fetchStockReport(String companyName,String baseDocumentType,String baseDocumentDocEntry);

    /**
     * 根据主键查询任务汇报
     * @param docEntry
     * @return
     */
    List<StockReport> fetchStockReportByEntry(Integer docEntry);

    /**
     * 保存任务汇报
     * @param stockReports
     */
    void saveStockReport(StockReport stockReports);


    void saveStockReportItem(StockReportItem stockReportItem);

    /**
     * 模糊查询
     * @param value 查询值
     * @return
     */
    List<StockReport> fetchStockReportFuzzy(String value);

    /**
     * 更新库存任务汇报
     * @param stockReport
     */
    void updateStockReport(StockReport stockReport);

    /**
     * 删除任务汇报
     * @param docEntry
     */
    void deleteStockReport(Integer docEntry);
}
