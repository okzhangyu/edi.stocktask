package org.edi.stocktask.bo.stockreport;

import java.math.BigDecimal;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReportItem {

    Integer getDocEntry();

    void setDocEntry(Integer value);

    Integer getLineId();

    void setLineId(Integer value);

    String getObjectCode();

    void  setObjectCode(String value);

    String getLineStatus();

    void setLineStatus(String value);

    String getReference1();

    void setReference1(String value);

    String getReference2();

    void setReference2(String value);

    String getBaseDocumentType();

    void setBaseDocumentType(String value);

    Integer getBaseDocumentEntry();

    void setBaseDocumentEntry(Integer value);

    Integer getBaseDocumentLineId();

    void setBaseDocumentLineId(Integer value);

    String getProjectCode();

    void setProjectCode(String value);

    String getDistributionRule1();

    void setDistributionRule1(String value);

    String getDistributionRule2();

    void setDistributionRule2(String value);

    String getDistributionRule3();

    void setDistributionRule3(String value);

    String getDistributionRule4();

    void setDistributionRule4(String value);

    String getDistributionRule5();

    void setDistributionRule5(String value);

    String getOriginalDocumentType();

    void setOriginalDocumentType(String value);

    Integer getOriginalDocumentEntry();

    void setOriginalDocumentEntry(Integer value);

    Integer getOriginalDocumentLineId();

    void  setOriginalDocumentLineId(Integer value);

    String getTargetDocumentType();

    void setTargetDocumentType(String value);

    Integer getTargetDocumentEntry();

    void setTargetDocumentEntry(Integer value);

    Integer getTargetDocumentLineId();

    void setTargetDocumentLineId(Integer value);

    String getItemCode();

    void setItemCode(String value);

    String getItemDescription();

    void setItemDescription(String value);

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

    String getBatchNumber();

    void setBatchNumber(String value);

    String getSerialNumber();

    void setSerialNumber(String value);

    String getBarCode1();

    void setBarCode1(String value);

    String getBarCode2();

    void setBarCode2(String value);

    String getBarCode3();

    void setBarCode3(String value);

    String getBarCode4();

    void setBarCode4(String value);

    String getBarCode5();

    void setBarCode5(String value);


}
