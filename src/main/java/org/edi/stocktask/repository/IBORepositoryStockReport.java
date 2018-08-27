package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stockreport.StockReport;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBORepositoryStockReport {


    List<StockReport> fetchStockReport(String token,String param,int beginIndex,int limit,List<String> docStatus);
    /**
     * 查询任务汇报清单
     * @return
     */
    /*List<StockReport> fetchStockReport(HashMap<String,Object> paramMap);*/



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
    StockReport fetchStockReport(Integer docEntry);

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

    void saveStockReport(String token,StockReport stockReport);


    /**
     * 更新库存任务汇报
     * @param stockReport
     */
    void updateStockReport(String token,StockReport stockReport);


    /**
     * 删除任务汇报
     * @param docEntry
     */
    void deleteStockReport(Integer docEntry);

}
