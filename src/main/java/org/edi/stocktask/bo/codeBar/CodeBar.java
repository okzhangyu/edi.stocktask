package org.edi.stocktask.bo.codeBar;

/**
 * @author Fancy
 * @date 2018/7/19
 */
public class CodeBar implements  ICodeBar{

    private String ProName;
    private String ProValue;

    @Override
    public String getProName() {return this.ProName;}
    @Override
    public void setProName(String value){
        this.ProName = value;
    }
    @Override
    public String getProValue() {
        return ProValue;
    }
    @Override
    public void setProValue(String value){
        this.ProValue = value;
    }

    public CodeBar() {

    }

    public CodeBar(String proName, String proValue) {
        ProName = proName;
        ProValue = proValue;
    }

    @Override
    public String toString() {
        return "CodeBar{" +
                "ProName='" + ProName + '\'' +
                ", ProValue='" + ProValue + '\'' +
                '}';
    }
}
