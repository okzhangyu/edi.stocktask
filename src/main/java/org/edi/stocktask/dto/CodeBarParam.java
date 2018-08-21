package org.edi.stocktask.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/8/20.
 */
public class CodeBarParam implements ICodeBarParam{

    private Integer baseLine;
    private Double quantity;
    private String itemCode;
    private List<CodeBarItem> codeBarItems;

    public CodeBarParam(){
        this.codeBarItems = new ArrayList<>();
    }
    @Override
    public String getItemCode() {
        return itemCode;
    }

    @Override
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public Double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }


    @Override
    public Integer getBaseLine() {
        return baseLine;
    }

    @Override
    public void setBaseLine(Integer baseLine) {
        this.baseLine = baseLine;
    }

    @Override
    public List<CodeBarItem> getCodeBarItems() {
        return codeBarItems;
    }

    @Override
    public void setCodeBarItems(List<CodeBarItem> codeBarItems) {
        this.codeBarItems = codeBarItems;
    }

}
