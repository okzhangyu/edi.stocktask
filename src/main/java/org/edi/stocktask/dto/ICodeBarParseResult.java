package org.edi.stocktask.dto;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

/**
 * @author Fancy
 * @date 2018/8/21
 */
public interface ICodeBarParseResult {


    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    String getItemCode();

    void setItemCode(String itemCode);

    String getCodeBar();

    void setCodeBar(String codeBar);

    Double getQuantity();

    void setQuantity(Double quantity);

    String getIndate();

    void setIndate(String inDate);

    String getExpDate();

    void setExpDate(String expDate);

    String getRemarks();

    void setRemarks(String remarks);

    String getPrdDate();

    void setPrdDate(String prdDate);
}
