package org.edi.stocktask.repository;

import org.edi.freamwork.exception.DBException;
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

    List<StockReport> fetchStockReportByPage ( String param,int beginIndex,int limit);

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

    void updateStockReportDocStatus(StockReport stockReport);

    /**
     * 保存任务汇报
     * @param stockReport
     */

    void saveStockReport(StockReport stockReport);



    /**
     * 模糊查询
     * @param value
     * @return
     */
    List<StockReport> fetchStockReportFuzzy(String value);

    /**
     * 更新库存任务汇报
     * @param stockReport
     */
    void updateStockReport(StockReport stockReport);

    /**
     * 更新保存库存任务汇报
     * @param stockReport
     */
     void updateSingleStockReport(StockReport stockReport) throws ParseException;
    /**
     * 删除任务汇报
     * @param docEntry
     */
    void deleteStockReport(Integer docEntry);

}
