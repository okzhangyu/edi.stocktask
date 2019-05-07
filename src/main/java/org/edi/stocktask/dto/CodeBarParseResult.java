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
<<<<<<< HEAD
    public String getIndate() {
=======
    public String getInDate() {
>>>>>>> 2432f02919f865d92cf2677f47d64611f51d5163
        return inDate;
    }

    @Override
<<<<<<< HEAD
    public void setIndate(String inDate) {
=======
    public void setInDate(String inDate) {
>>>>>>> 2432f02919f865d92cf2677f47d64611f51d5163
        this.inDate = inDate;
    }

    @Override
    public String getExpDate() {
        return expDate;
    }

    @Override
    public void setExpDate(String expDate) {
<<<<<<< HEAD
        this.expDate=expDate;
=======
        this.expDate = expDate;
    }

    @Override
    public String getPrdDate() {
        return prdDate;
    }

    @Override
    public void setPrdDate(String prdDate) {
        this.prdDate = prdDate;
>>>>>>> 2432f02919f865d92cf2677f47d64611f51d5163
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
<<<<<<< HEAD
        this.remarks=remarks;
    }

    @Override
    public String getPrdDate() {
        return prdDate;
    }

    @Override
    public void setPrdDate(String prdDate) {
        this.prdDate=prdDate;
=======
        this.remarks = remarks;
    }

    @Override
    public String getBatchNum() {
        return batchNum;
    }

    @Override
    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    @Override
    public String getSerialNum() {
        return serialNum;
    }

    @Override
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
>>>>>>> 2432f02919f865d92cf2677f47d64611f51d5163
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
