package org.edi.stocktask.dto;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.List;

/**
 * Created by asus on 2018/8/20.
 */
public interface ICodeBarParam {

    String getItemCode();

    void setItemCode(String itemCode);

    Double getQuantity();

    void setQuantity(Double quantity);

    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    List<CodeBarItem> getCodeBarItems();

    void setCodeBarItems(List<CodeBarItem> codeBarItems);
}
