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
    private String inDate;
    private String expDate;
    private String prdDate;
    private String remarks;




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
    public String getIndate() {
        return inDate;
    }

    @Override
    public void setIndate(String inDate) {
        this.inDate = inDate;
    }

    @Override
    public String getExpDate() {
        return expDate;
    }

    @Override
    public void setExpDate(String expDate) {
        this.expDate=expDate;
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks=remarks;
    }

    @Override
    public String getPrdDate() {
        return prdDate;
    }

    @Override
    public void setPrdDate(String prdDate) {
        this.prdDate=prdDate;
    }

    @Override
    public String toString() {
        return "{" +
                "baseLine:" + baseLine +
                ", itemCode:'" + itemCode + '\'' +
                ", codeBar:'" + codeBar + '\'' +
                ", quantity:" + quantity +
                '}';
    }
}
