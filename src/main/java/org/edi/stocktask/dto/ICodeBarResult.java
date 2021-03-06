package org.edi.stocktask.dto;

import java.util.List;

/**
 * Created by asus on 2018/8/20.
 */
public interface ICodeBarResult {

    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    String getItemCode();

    void setItemCode(String itemCode);

    Double getQuantity();

    void setQuantity(Double quantity);

    List<CodeBarItem> getCodeBarItems();

    void setCodeBarItems(List<CodeBarItem> codeBarItems);
}
