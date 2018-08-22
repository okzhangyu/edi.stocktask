package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/8/21.
 */
public interface IBarCodes{
     String getItemCode();

     void setItemCode(String itemCode);

     Integer getBaseLine();

     void setBaseLine(Integer baseLine);

     String getBarCode();

     void setBarCode(String barCode);

    Double getQuantity();

     void setQuantity(Double quantity);
}
