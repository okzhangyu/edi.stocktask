package org.edi.stocktask.dto;


import javax.persistence.criteria.CriteriaBuilder;

public class CodeBarParam implements ICodeBarParam {

    private String codeBar;

    @Override
    public String getCodeBar() {
        return codeBar;
    }

    @Override
    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    private String baseType;
    @Override
    public String getBaseType() {
        return baseType;
    }

    @Override
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    private Integer baseEntry;
    @Override
    public Integer getBaseEntry() {
        return baseEntry;
    }

    @Override
    public void setBaseEntry(Integer baseEntry) {
        this.baseEntry = baseEntry;
    }

    private String baseLine;
    @Override
    public String getBaseLine() {
        return baseLine;
    }

    @Override
    public void setBaseLine(String baseLine) {
        this.baseLine = baseLine;
    }
}
