package org.edi.stocktask.dto;

/**
 * 条码解析对象
 */
public interface ICodeBarParam {

    String getCodeBar();

    void setCodeBar(String codeBar);

    String getBaseType();

    void setBaseType(String baseType);

    Integer getBaseEntry();

    void setBaseEntry(Integer baseEntry);

    String getBaseLine();

    void setBaseLine(String baseLine);
}
