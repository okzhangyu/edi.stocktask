package org.edi.stocktask.dto;

/**
 * Created by asus on 2018/9/6.
 */
public class ItemCodeQuantity implements IItemCodeQuantity{

    private String id;
    private String itemCode;
    private Double quantity;
    private String barCode;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String getBarCode() {
        return barCode;
    }

    @Override
    public void setBarCode(String barCode) {
        this.barCode = barCode;
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
                ", id='" + id + '\'' +
                '}';
    }
}
