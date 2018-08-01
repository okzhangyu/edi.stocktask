package org.edi.stocktask.bo.material;

/**
 * @author Fancy
 * @date 2018/7/31
 */
public class Material implements IMaterial{

    private String itemCode;
    private String itemDescription;

    @Override
    public String getItemCode() {
        return itemCode;
    }

    @Override
    public void setItemCode(String value) {
        itemCode = value;
    }

    @Override
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public void setItemDescription(String value) {
        itemDescription = value;
    }
}
