package org.edi.stocktask.bo.stocktask;

import java.math.BigDecimal;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockTaskItem {

    Integer getObjectKey();

    void setObjectKey(Integer value);

    String getObjectCode();

    void setObjectCode(String value);

    Integer getLineId();

    void setLineId(Integer value);

    String getLineStatus();

    void setLineStatus(String  value);

    String getReference1();

    void setReference1(String value);

    String getReference2();

    void setReference2(String value);

    String getDocumentType();

    void setDocumentType(String value);

    Integer getDocumentEntry();

    void setDocumentEntry(Integer value);

    Integer getDocumentLineId();

    void setDocumentLineId(Integer valua);

    String getItemCode();

    void setItemCode(String value);

    String getItemDescription();

    void setItemDescription(String value);

    BigDecimal getPackageQuantity();

    void setPackageQuantity(BigDecimal value);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal value);

    String getInventoryUoM();

    void setInventoryUoM(String value);

    String getSerialNumberManagement();

    void setSerialNumberManagement(String value);

    String getBatchNumberManagement();

    void setBatchNumberManagement(String value);

    String getServiceNumberManagement();

    void setServiceNumberManagement(String value);

    BigDecimal getPrice();

    void setPrice(BigDecimal value);

    String getCurrency();

    void setCurrency(String value);

    BigDecimal getCurrencyRate();

    void setCurrencyRate(BigDecimal value);

    BigDecimal getLineTotal();

    void setLineTotal(BigDecimal value);

    String getFromWarehose();

    void setFromWarehose(String value);

    String getFromLocation();

    void setFromLocation(String value);

    String getToWarehouse();

    void setToWarehouse(String value);

    String getToLocation();

    void setToLocation(String value);

    String getTransactionType();

    void setTransactionType(String value);

    String getBaseDocumentType();

    void setBaseDocumentType(String value);

    Integer getBaseDocumentEntry();

    void setBaseDocumentEntry(Integer value);

    Integer getBaseDocumentLineId();

    void setBaseDocumentLineId(Integer value);

    String getOriginalDocumentType();

    void setOriginalDocumentType(String value);

    Integer getOriginalDocumentEntry();

    void setOriginalDocumentEntry(Integer value);

    Integer getOriginalDocumentLineId();

    void setOriginalDocumentLineId(Integer value);

    String getScanningType();

    void setScanningType(String value);

    String getWaterCode();

    void setWaterCode(String value);



}
