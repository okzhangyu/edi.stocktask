package org.edi.stocktask.dto;

import java.util.List;

/**
 * 条码解析对象
 */
public interface ICodeBarParam {

     Integer getBaseEntry();
     void setBaseEntry(Integer baseEntry);

     String getBaseType();
     void setBaseType(String baseType);

     List<String> getCodeBar();
     void setCodeBar(List<String> codeBar);



}
