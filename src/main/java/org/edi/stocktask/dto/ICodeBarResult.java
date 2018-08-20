package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/8/20.
 */
public interface ICodeBarResult {

    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    String getItemCode();

    void setItemCode(String itemCode);

    String getCodeBar();

    void setCodeBar(String codeBar);

    Double getQuantity();

    void setQuantity(Double quantity);
}
