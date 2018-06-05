package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stockreport.StockReport;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReportService {
    Result<StockReport> fetchStockReport(String token);
    Result<?> SaveStockReport(List<StockReport> stockReports);

}
