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
    public String toString() {
        return "{" +
                "baseLine:" + baseLine +
                ", itemCode:'" + itemCode + '\'' +
                ", codeBar:'" + codeBar + '\'' +
                ", quantity:" + quantity +
                '}';
    }
}
