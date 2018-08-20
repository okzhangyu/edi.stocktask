package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/8/20.
 */
public class CodeBarResult implements ICodeBarResult {
    private String baseType;
    private Integer baseEntry;
    private Integer baseLine;
    private String itemCode;
    private String codeBar;

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public Integer getBaseEntry() {
        return baseEntry;
    }

    public void setBaseEntry(Integer baseEntry) {
        this.baseEntry = baseEntry;
    }

    public Integer getBaseLine() {
        return baseLine;
    }

    public void setBaseLine(Integer baseLine) {
        this.baseLine = baseLine;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

}
