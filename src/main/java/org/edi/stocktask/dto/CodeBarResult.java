package org.edi.stocktask.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by asus on 2018/8/20.
 */
public class CodeBarResult implements ICodeBarResult {

    public static List<CodeBarResult> createCodeBarResult(List<CodeBarParseResult> codeBarParseResults){
        List<CodeBarResult> codeBarResults = new ArrayList<>();
        CodeBarResult codeBarResult ;
        CodeBarItem codeBarItem;
        for (CodeBarParseResult codeBarParseResult:
                codeBarParseResults) {
            codeBarItem = new CodeBarItem();
            codeBarItem.setBarCode(codeBarParseResult.getCodeBar());

            List<CodeBarResult> newList = codeBarResults.stream()
                    .filter(c->c.getBaseLine().equals(codeBarParseResult.getBaseLine())
                            && c.getItemCode().equals(codeBarParseResult.getItemCode())
                            && c.getQuantity().equals(codeBarParseResult.getQuantity()))
                    .collect(Collectors.toList());

            if(newList != null && newList.size() > 0){
               newList.get(0).getCodeBarItems().add(codeBarItem);
            }else{
                codeBarResult = new CodeBarResult();
                codeBarResult.getCodeBarItems().add(codeBarItem);
                codeBarResult.setItemCode(codeBarParseResult.getItemCode());
                codeBarResult.setBaseLine(codeBarParseResult.getBaseLine());
                codeBarResult.setQuantity(codeBarParseResult.getQuantity());
                codeBarResults.add(codeBarResult);
            }
        }
        return codeBarResults;
    }

    public CodeBarResult(){
        this.codeBarItems = new ArrayList<>();
    }
    private Integer baseLine;
    private String itemCode;
    private Double quantity;
    private List<CodeBarItem> codeBarItems;
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
    public Double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public List<CodeBarItem> getCodeBarItems() {
        return codeBarItems;
    }

    @Override
    public void setCodeBarItems(List<CodeBarItem> codeBarItems) {
        this.codeBarItems = codeBarItems;
    }

    @Override
    public String toString() {
        return "{" +
                "baseLine:" + baseLine +
                ", itemCode:'" + itemCode + '\'' +
                ", quantity:" + quantity +
                ", codeBarItems:" + codeBarItems +
                '}';
    }
}
