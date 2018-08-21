package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/20
 * 条码明细
 */
public interface ICodeBarItem {

    String getCodeBar();

    void setCodeBar(String codeBar);

    Double getCodeBarQty();

    void setCodeBarQty(Double quantity);
}
