package org.edi.stocktask.service;

import org.edi.freamwork.data.Result;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.dto.DocumentSyncResult;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReportService {
    /**
     * 查询库存任务汇报
     * @param token
     * @param param
     * @return
     */


    Result<StockReport> fetchStockReport(String token, String param, int beginIndex, int limit,List<String> docStatus,List<String>transactionType);

    /**
     * 保存库存任务汇报
     * @param token
     * @param stockReport
     * @return
     */
    Result saveStockReport(String token,StockReport stockReport);

    /**
     * 更新库存任务汇报
     * @param token
     * @param stockReport
     * @return
     */
    Result updateStockReport(String token,StockReport stockReport);

    /**
     * 删除库存任务汇报
     * @param token
     * @param docEntry
     * @return
     */
    Result deleteStockReport(String token,int docEntry);


    Result<DocumentSyncResult> syncStockReportToB1(String token, List<StockReport> stockReports);


}
