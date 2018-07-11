package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.StockReport;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReportService {
    /**
     * 查询库存任务汇报
     * @param token
     * @return
     */
    Result<StockReport> fetchStockReport(String token);

    /**
     * 保存库存任务汇报
     * @param token
     * @param stockReports
     * @return
     */
    Result<?> saveStockReport(String token,List<StockReport> stockReports);

    /**
     * 更新库存任务汇报
     * @param token
     * @param stockReports
     * @return
     */
    Result updateStockReport(String token,List<StockReport> stockReports);

    /**
     * 删除库存任务汇报
     * @param token
     * @param docEntry
     * @return
     */
    Result<?> deleteStockReport(String token,int docEntry);




}
