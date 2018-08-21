package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/21
 */
public interface ICodeBarParseResult {
    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    String getItemCode();

    void setItemCode(String itemCode);

    String getCodeBar();

    void setCodeBar(String codeBar);

    Double getQuantity();

    void setQuantity(Double quantity);

    Double getCodeBarQty();

    void setCodeBarQty(Double quantity);
}
