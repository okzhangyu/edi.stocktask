package org.edi.stocktask.dto;

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

    String getSerialNum();

    void setSerialNum(String serialNum);

    String getBatchNum();

    void setBatchNum(String batchNum);

    String getInDate();

    void setInDate(String inDate);

    String getExpDate();

    void setExpDate(String expDate);

    String getPrdDate();

    void setPrdDate(String prdDate);

    String getRemarks();

    void setRemarks(String remarks);
}
