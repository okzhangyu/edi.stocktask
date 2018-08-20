package org.edi.stocktask.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/8/20
 * 传入存储过程参数  匹配表值对象类型
 */
public class CodeBarParseParam implements ICodeBarParseParam{


    public static List<CodeBarParseParam> createParseParam(List<CodeBarParam>codeBarParams){
        List<CodeBarParseParam> codeBarParseParams = new ArrayList<>();
        CodeBarParseParam codeBarParseParam;
        for (CodeBarParam codeBarParam:
             codeBarParams) {
            for (CodeBarItem item:
                    codeBarParam.getCodeBarItems()) {
                codeBarParseParam = new CodeBarParseParam();
                codeBarParseParam.setBaseLine(codeBarParam.getBaseLine());
                codeBarParseParam.setItemCode(codeBarParam.getItemCode());
                codeBarParseParam.setQuantity(codeBarParam.getQuantity());
                codeBarParseParam.setCodeBar(item.getCodeBar());
                codeBarParseParam.setCodeBarQty(item.getCodeBarQty());
                codeBarParseParams.add(codeBarParseParam);
            }
        }
        return codeBarParseParams;
    }
    private Integer baseLine;
    private Double quantity;
    private String itemCode;
    private Double codeBarQty;
    private String codeBar;

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
    public Double getCodeBarQty() {
        return codeBarQty;
    }

    @Override
    public void setCodeBarQty(Double codeBarQty) {
        this.codeBarQty = codeBarQty;
    }
}
