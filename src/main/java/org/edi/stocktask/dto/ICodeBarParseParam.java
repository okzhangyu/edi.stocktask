package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/20
 */
public interface ICodeBarParseParam {

    String getItemCode();

    void setItemCode(String itemCode);

    Double getQuantity();

    void setQuantity(Double quantity);

    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    String getCodeBar();

    void setCodeBar(String codeBar);

    Double getCodeBarQty();

    void setCodeBarQty(Double quantity);
}
