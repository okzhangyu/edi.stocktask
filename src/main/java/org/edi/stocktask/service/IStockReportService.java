package org.edi.stocktask.service;

import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.initialfantasy.dto.IResult;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReportService {

    IResult<IStockReport> fetchStockReport(String token);

    IResult<?> SaveStockReport(List<IStockReport> stockReports, String token);
}
