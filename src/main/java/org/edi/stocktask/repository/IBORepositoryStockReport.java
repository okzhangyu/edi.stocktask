package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stockreport.StockReport;

import java.text.ParseException;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBORepositoryStockReport {

    /**
     * 查询任务汇报清单
     * @return
     */
    List<StockReport> fetchStockReport(String param);

    /**
     * 条件查询任务汇报
     * @return
     */
    List<StockReport> fetchStockReportByCondition(String companyName,String baseDocumentType,String baseDocumentEntry);

    /**
     * 根据主键查询任务汇报
     * @param docEntry
     * @return
     */
    StockReport fetchStockReportByEntry(Integer docEntry);

    /**
     * 查询未清任务汇报
     * @return
     */
    List<StockReport> fetchUnSyncStockReport();

    void UpdateStockReportDocStatus(String B1DocEntry,Integer docEntry);

    /**
     * 保存任务汇报
     * @param stockReports
     */

    void saveStockReports(List<StockReport> stockReports)throws ParseException;



    /**
     * 模糊查询
     * @param value
     * @return
     */
    List<StockReport> fetchStockReportFuzzy(String value);

    /**
     * 更新库存任务汇报
     * @param stockReports
     */
    void updateStockReport(List<StockReport> stockReports);

    /**
     * 删除任务汇报
     * @param docEntry
     */
    void deleteStockReport(Integer docEntry);

}
