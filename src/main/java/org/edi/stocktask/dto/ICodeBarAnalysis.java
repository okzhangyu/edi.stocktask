package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/8/18.
 */
public interface ICodeBarAnalysis {
     Integer getBaseEntry();

     void setBaseEntry(Integer baseEntry);

     String getBaseType();

     void setBaseType(String baseType);

     Integer getBaseLine();

     void setBaseLine(Integer baseLine);

     String getCodeBar();

     void setCodeBar(String codeBar);

     String getItemCode();

     void setItemCode(String itemCode);

     double getQuantity();

     void setQuantity(double quantity);

     double getPrice();

     void setPrice(double price);

     String getBatchNumber();

     void setBatchNumber(String batchNumber);

     String getSerialNumber();

     void setSerialNumber(String serialNumber);
}
