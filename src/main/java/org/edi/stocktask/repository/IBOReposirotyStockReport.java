package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;

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

    /**
     * 条件查询任务汇报
     * @return
     */
    StockReport fetchStockReport(String companyName,String baseDocumentType,String baseDocumentDocEntry);

    /**
     * 根据主键查询任务汇报
     * @param docEntry
     * @return
     */
    StockReport fetchStockReportByEntry(Integer docEntry);

    /**
     * 保存任务汇报
     * @param stockReports
     */

    void saveStockReports(List<StockReport> stockReports);



    /**
     * 模糊查询
     * @param docEntry
     * @param BpCode
     * @param BpName
     * @return
     */
    List<StockReport> fetchStockReportFuzzy(String docEntry,String BpCode,String BpName);

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
