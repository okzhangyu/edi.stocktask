package org.edi.stocktask.dto;

import java.util.List;

/**
 * Created by asus on 2018/8/20.
 */
public interface ICodeBarParam {

     Integer getBaseEntry();

     void setBaseEntry(Integer baseEntry);

     String getBaseType();

     void setBaseType(String baseType);

     List<CodeBarItem> getBarCodes();

     void setBarCodes(List<CodeBarItem> barCodes);
}
