package org.edi.stocktask.service;

import org.edi.stocktask.bo.stocktask.IStockReport;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReportService {

    String fetchStockReport();

    String SaveStockReport(IStockReport stockReport);
}
