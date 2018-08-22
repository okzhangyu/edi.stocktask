package org.edi.stocktask.bo.codeBar;

/**
 * @author Fancy
 * 条码解析返回对象
 * @date 2018/7/19
 */
public class CodeBar implements  ICodeBar{

    private String proName;
    private String proValue;
    private String proDesc;


    @Override
    public String getProName() {return this.proName;}
    @Override
    public void setProName(String value){
        this.proName = value;
    }

    @Override
    public String getProDesc() {
        return this.proDesc;
    }

    @Override
    public void setProDesc(String value) {
        this.proDesc = value;
    }

    @Override
    public String getProValue() {
        return proValue;
    }
    @Override
    public void setProValue(String value){
        this.proValue = value;
    }

    public CodeBar() {

    }


    @Override
    public String toString() {
        return "{" +
                "ProName:'" + proName + '\'' +
                ", ProValue:'" + proValue + '\'' +
                ", ProDesc:'" + proDesc + '\'' +
                '}';
    }
}
