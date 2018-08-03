package org.edi.stocktask.util;

import org.edi.initialfantasy.data.ResultDescription;
import org.edi.stocktask.bo.stockreport.StockReport;

import java.util.List;

/**
 * Created by asus on 2018/8/2.
 */
public class ReportVerification {
    public static String reportCheck(List<StockReport> stockReports){
        if (stockReports.size() == 0) {
            return  ResultDescription.PARAMETER_IS_NULL;
        }
        if(stockReports.get(0).getStockReportItems().size()==0){
            return ResultDescription.DETAIL_IS_NULL;
        }
        return "ok";
    }
}
