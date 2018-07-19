package org.edi.stocktask.util;

import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.mapper.StockReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/7/11.
 */

@Component(value="b1DocEntryVerification")
public class B1DocEntryVerification {

    @Autowired
    private StockReportMapper stockReportMapper;

    public boolean B1EntryCheck(int docEntry){
        boolean check = false;
        StockReport stockReport = stockReportMapper.fetchStockReportByEntry(docEntry);
        if(stockReport.getB1DocEntry()==null||stockReport.getB1DocEntry().equals("")||stockReport.getB1DocEntry()==0){
            check = true;
        }
        return check;
    }


}
