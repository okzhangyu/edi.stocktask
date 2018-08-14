package org.edi.stocktask.util;

import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportMaterialItem;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static void materialItemCheck(List<StockReportMaterialItem> stockReportMaterialItems){
        if(stockReportMaterialItems.size()==0||stockReportMaterialItems==null){
            throw new BusinessException(ResultCode.MATERIALITEM_IS_NULL,ResultDescription.MATERIALITEM_IS_NULL);
        }

        HashMap<Integer,String> codeBarMap = new HashMap<>();
        for(int i=0;i<stockReportMaterialItems.size();i++){
            StockReportMaterialItem stockReportMaterialItem = stockReportMaterialItems.get(i);
            codeBarMap.put(i+1,stockReportMaterialItem.getBarCode());
        }


        for(StockReportMaterialItem stockReportMaterialItem:stockReportMaterialItems){
            String barCode = stockReportMaterialItem.getBarCode();
            if(getKeyList(codeBarMap,barCode).size()>1){
                throw new BusinessException(ResultCode.CODEBAR_IS_REPEAT,ResultDescription.CODEBAR_IS_REPEAT);
            }

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



    public static void reportSaveCheck(StockReport stockReport){
        if (stockReport.getBaseDocumentType()==null||stockReport.getBaseDocumentType().isEmpty()) {
            throw new BusinessException(ResultCode.PARAMETER_IS_NULL,ResultDescription.PARAMETER_IS_NULL);
        }
        if(stockReport.getStockReportItems().size()==0){
            throw new BusinessException(ResultCode.DETAIL_IS_NULL,ResultDescription.DETAIL_IS_NULL);
        }

    }



    public static void reportUpdateCheck(StockReport stockReport){
        if (stockReport.getDocEntry()==null) {
            throw new BusinessException(ResultCode.PARAMETER_IS_NULL,ResultDescription.PARAMETER_IS_NULL);
        }
        if(stockReport.getStockReportItems().size()==0){
            throw new BusinessException(ResultCode.DETAIL_IS_NULL,ResultDescription.DETAIL_IS_NULL);
        }

    }

}
