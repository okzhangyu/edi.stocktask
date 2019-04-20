package org.edi.stocktask.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Fancy
 * @date 2018/8/20
 * 传入存储过程参数  匹配表值对象类型
 */
public class CodeBarParseParam implements ICodeBarParseParam{


    public static List<CodeBarParseParam> createParseParam(CodeBarParam codeBarParams){
        List<CodeBarParseParam> codeBarParseParams = new ArrayList<>();
        CodeBarParseParam codeBarParseParam;
            for (CodeBarItem item:
                    codeBarParams.getBarCodes()) {
                codeBarParseParam = new CodeBarParseParam();
                codeBarParseParam.setItemCode(item.getItemCode());
                codeBarParseParam.setBaseLine(item.getBaseLine());
                codeBarParseParam.setCodeBar(item.getBarCode());
                codeBarParseParam.setQuantity(item.getQuantity());
                codeBarParseParam.setQtyPlan(item.getQtyPlan());
                codeBarParseParam.setRemark(item.getRemark());
                codeBarParseParams.add(codeBarParseParam);
            }

        return codeBarParseParams;
    }

    private Integer baseLine;
    private Double quantity;
    private String itemCode;
    private String codeBar;
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
    public Double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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
    public String getCodeBar() {
        return codeBar;
    }

    @Override
    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
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
                "baseLine:" + baseLine +
                ", quantity:" + quantity +
                ", itemCode:'" + itemCode + '\'' +
                ", codeBar:'" + codeBar + '\'' +
                ", remark:'" + remark + '\'' +
                ", qtyPlan:'" + qtyPlan + '\'' +
                '}';
    }
}
