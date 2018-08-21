package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/20
 */
public class CodeBarItem implements ICodeBarItem{

    private Double codeBarQty;
    private String codeBar;

    @Override
    public String getCodeBar() {
        return codeBar;
    }

    @Override
    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    @Override
    public Double getCodeBarQty(){
        return codeBarQty;
    }

    @Override
    public void setCodeBarQty(Double quantity){
        this.codeBarQty = quantity;
    }
}
