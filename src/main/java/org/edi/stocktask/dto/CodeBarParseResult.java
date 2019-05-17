package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/21
 */
public class CodeBarParseResult implements ICodeBarParseResult {


    private Integer baseLine;
    private String itemCode;
    private String codeBar;
    private Double quantity;
    private String batchNum;
    private String serialNum;
    private String remarks;
    private String inDate;
    private String expDate;
    private String prdDate;


    @Override
    public Integer getBaseLine() {
        return baseLine;
    }

    @Override
    public void setBaseLine(Integer baseLine) {
        this.baseLine = baseLine;
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
    public Double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getSerialNum() {
        return serialNum;
    }

    @Override
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String getBatchNum() {
        return this.batchNum;
    }

    @Override
    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    @Override
    public String getInDate() {
        return this.inDate;
    }

    @Override
    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    @Override
    public String getExpDate() {
        return expDate;
    }

    @Override
    public void setExpDate(String expDate) {
        this.expDate =expDate;
    }

    @Override
    public String getPrdDate() {
        return this.prdDate;
    }

    @Override
    public void setPrdDate(String prdDate) {
        this.prdDate = prdDate;
    }

    @Override
    public String getRemarks() {
        return this.remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public String toString() {
        return "CodeBarParseResult{" +
                "baseLine=" + baseLine +
                ", itemCode='" + itemCode + '\'' +
                ", codeBar='" + codeBar + '\'' +
                ", quantity=" + quantity +
                ", batchNum='" + batchNum + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", remarks='" + remarks + '\'' +
                ", inDate='" + inDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", prdDate='" + prdDate + '\'' +
                '}';
    }
}
