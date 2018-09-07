package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/9/6.
 */
public class ItemCodeQuantity implements IItemCodeQuantity{
    private String itemCode;
    private Double quantity;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ItemCodeQuantity() {
    }

    public ItemCodeQuantity(String itemCode, Double quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemCodeQuantity{" +
                "itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
