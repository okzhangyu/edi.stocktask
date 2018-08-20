package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/8/20.
 */
public class CodeBarParam implements ICodeBarParam{
    private String baseType;
    private Integer baseEntry;
    private Integer baseLine;
    private Double quantity;
    private String itemCode;
    private String codeBar;

    @Override
    public String getBaseType() {
        return baseType;
    }

    @Override
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    @Override
    public Integer getBaseEntry() {
        return baseEntry;
    }

    @Override
    public void setBaseEntry(Integer baseEntry) {
        this.baseEntry = baseEntry;
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
    public String getCodeBar() {
        return codeBar;
    }

    @Override
    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    @Override
    public Double getQuantity(){
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity){
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

}
