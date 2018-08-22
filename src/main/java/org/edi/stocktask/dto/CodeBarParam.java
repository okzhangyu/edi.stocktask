package org.edi.stocktask.dto;

import java.util.List;

/**
 * Created by asus on 2018/8/20.
 */
public class CodeBarParam implements ICodeBarParam{

    private Integer baseEntry;
    private String baseType;
    private List<CodeBarItem> barCodes;

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
    public List<CodeBarItem> getBarCodes() {
        return barCodes;
    }

    @Override
    public void setBarCodes(List<CodeBarItem> barCodes) {
        this.barCodes = barCodes;
    }

    @Override
    public String toString() {
        return "{" +
                "baseEntry:" + baseEntry +
                ", baseType:'" + baseType + '\'' +
                ", barCodes=" + barCodes +
                '}';
    }
}
