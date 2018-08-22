package org.edi.stocktask.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportMaterialItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 2018/8/2.
 */
public class ReportVerification {
    public static String reportCheck(List<StockReport> stockReports){
        if (stockReports.size() == 0) {
            return  StockOpResultDescription.PARAMETER_IS_NULL;
        }
        if(stockReports.get(0).getStockReportItems().size()==0){
            return StockOpResultDescription.DETAIL_IS_NULL;
        }
        return "ok";
    }

    public static void materialItemCheck(List<StockReportMaterialItem> stockReportMaterialItems){
        if(stockReportMaterialItems.size()==0||stockReportMaterialItems==null){
            throw new BusinessException(StockOpResultCode.MATERIALITEM_IS_NULL,StockOpResultDescription.MATERIALITEM_IS_NULL);
        }
    }


     //根据value值获取到对应的所有的key值
     public static List<Integer> getKeyList(HashMap<Integer,String> map,String value){
             List<Integer> keyList = new ArrayList();
            for(Integer getKey: map.keySet()){
                     if(map.get(getKey).equals(value)){
                           keyList.add(getKey);
                       }
                   }
              return keyList;
           }


//
//    public static void reportSaveCheck(StockReport stockReport){
//        if (stockReport.getBaseDocumentType()==null||stockReport.getBaseDocumentType().isEmpty()) {
//            throw new BusinessException(StockOpResultCode.PARAMETER_IS_NULL,StockOpResultDescription.PARAMETER_IS_NULL);
//        }
//        if(stockReport.getStockReportItems().size()==0){
//            throw new BusinessException(StockOpResultCode.DETAIL_IS_NULL,StockOpResultDescription.DETAIL_IS_NULL);
//        }
//
//    }


//
//    public static void reportUpdateCheck(StockReport stockReport){
//        if (stockReport.getDocEntry()==null) {
//            throw new BusinessException(StockOpResultCode.PARAMETER_IS_NULL,StockOpResultDescription.PARAMETER_IS_NULL);
//        }
//        if(stockReport.getStockReportItems().size()==0){
//            throw new BusinessException(StockOpResultCode.DETAIL_IS_NULL,StockOpResultDescription.DETAIL_IS_NULL);
//        }
//
//    }

}
