package org.edi.stocktask.dto;


import java.util.List;

public class CodeBarParam implements ICodeBarParam {
    private Integer baseEntry;
    private String baseType;
    private List<String> codeBar;


    @Override
    public Integer getBaseEntry() {
        return baseEntry;
    }

    @Override
    public void setBaseEntry(Integer baseEntry) {
        this.baseEntry = baseEntry;
    }

    @Override
    public String getBaseType() {
        return baseType;
    }

    @Override
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    @Override
    public List<String> getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(List<String> codeBar) {
        this.codeBar = codeBar;
    }
}
