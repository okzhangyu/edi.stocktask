package org.edi.stocktask.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Fancy
 * @date 2018/8/20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeBarItem implements ICodeBarItem{

    private String itemCode;
    private Integer baseLine;
    private String barCode;
    private Double quantity;
    private Double qtyPlan;
    private String remark;

    @Override
    public String getItemCode() {
        return itemCode;
    }

    @Override
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public Integer getBaseLine() {
        return baseLine;
    }

    @Override
    public void setBaseLine(Integer baseLine) {
        this.baseLine = baseLine;
    }

    @Override
    public String getBarCode() {
        return barCode;
    }

    @Override
    public void setBarCode(String barCode) {
        this.barCode = barCode;
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
    public Double getQtyPlan() {
        return qtyPlan;
    }

    @Override
    public void setQtyPlan(Double qtyPlan) {
        this.qtyPlan = qtyPlan;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{" +
                "itemCode:'" + itemCode + '\'' +
                ", baseLine:" + baseLine +
                ", barCode:'" + barCode + '\'' +
                ", quantity:" + quantity +
                ", remark:'" + remark + '\'' +
                ", qtyPlan:" + qtyPlan +
                '}';
    }
}
