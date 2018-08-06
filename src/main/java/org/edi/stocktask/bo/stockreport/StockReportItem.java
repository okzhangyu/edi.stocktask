package org.edi.stocktask.bo.stockreport;


import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.bo.DocumentBOLine;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/27
 */
public class StockReportItem extends DocumentBOLine implements IStockReportItem{
    private Integer docEntry;
    private Integer lineId;
    private String objectCode;
    private String lineStatus;
    private String reference1;
    private String reference2;
    private String baseDocumentType;
    private Integer baseDocumentEntry;
    private Integer baseDocumentLineId;
    private String projectCode;
    private String distributionRule1;
    private String distributionRule2;
    private String distributionRule3;
    private String distributionRule4;
    private String distributionRule5;
    private String originalDocumentType;
    private Integer originalDocumentEntry;
    private Integer originalDocumentLineId;
    private String targetDocumentType;
    private Integer targetDocumentEntry;
    private Integer targetDocumentLineId;
    private String itemCode;
    private String itemDescription;
    private Double quantity;
    private String inventoryUoM;
    private String serialNumberManagement;
    private String batchNumberManagement;
    private String serviceNumberManagement;
    private Double price;
    private String currency;
    private Double currencyRate;
    private Double lineTotal;
    private String fromWarehose;
    private String fromLocation;
    private String toWarehouse;
    private String toLocation;
    private String batchNumber;
    private String serialNumber;
    private String barCode1;
    private String barCode2;
    private String barCode3;
    private String barCode4;
    private String barCode5;
    private List<StockReportMaterialItem> stockReportMaterialItems;

    @Override
    public Integer getDocEntry() {
        return docEntry;
    }

    @Override
    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    @Override
    public Integer getLineId() {
        return lineId;
    }

    @Override
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    @Override
    public String getObjectCode() {
        return objectCode;
    }

    @Override
    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    @Override
    public String getLineStatus() {
        return lineStatus;
    }

    @Override
    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    @Override
    public String getReference1() {
        return reference1;
    }

    @Override
    public void setReference1(String reference1) {
        this.reference1 = reference1;
    }

    @Override
    public String getReference2() {
        return reference2;
    }

    @Override
    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    @Override
    public String getBaseDocumentType() {
        return baseDocumentType;
    }

    @Override
    public void setBaseDocumentType(String baseDocumentType) {
        this.baseDocumentType = baseDocumentType;
    }

    @Override
    public Integer getBaseDocumentEntry() {
        return baseDocumentEntry;
    }

    @Override
    public void setBaseDocumentEntry(Integer baseDocumentEntry) {
        this.baseDocumentEntry = baseDocumentEntry;
    }

    @Override
    public Integer getBaseDocumentLineId() {
        return baseDocumentLineId;
    }

    @Override
    public void setBaseDocumentLineId(Integer baseDocumentLineId) {
        this.baseDocumentLineId = baseDocumentLineId;
    }

    @Override
    public String getProjectCode() {
        return projectCode;
    }

    @Override
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String getDistributionRule1() {
        return distributionRule1;
    }

    @Override
    public void setDistributionRule1(String distributionRule1) {
        this.distributionRule1 = distributionRule1;
    }

    @Override
    public String getDistributionRule2() {
        return distributionRule2;
    }

    @Override
    public void setDistributionRule2(String distributionRule2) {
        this.distributionRule2 = distributionRule2;
    }

    @Override
    public String getDistributionRule3() {
        return distributionRule3;
    }

    @Override
    public void setDistributionRule3(String distributionRule3) {
        this.distributionRule3 = distributionRule3;
    }

    @Override
    public String getDistributionRule4() {
        return distributionRule4;
    }

    @Override
    public void setDistributionRule4(String distributionRule4) {
        this.distributionRule4 = distributionRule4;
    }

    @Override
    public String getDistributionRule5() {
        return distributionRule5;
    }

    @Override
    public void setDistributionRule5(String distributionRule5) {
        this.distributionRule5 = distributionRule5;
    }

    @Override
    public String getOriginalDocumentType() {
        return originalDocumentType;
    }

    @Override
    public void setOriginalDocumentType(String originalDocumentType) {
        this.originalDocumentType = originalDocumentType;
    }

    @Override
    public Integer getOriginalDocumentEntry() {
        return originalDocumentEntry;
    }

    @Override
    public void setOriginalDocumentEntry(Integer originalDocumentEntry) {
        this.originalDocumentEntry = originalDocumentEntry;
    }

    @Override
    public Integer getOriginalDocumentLineId() {
        return originalDocumentLineId;
    }

    @Override
    public void setOriginalDocumentLineId(Integer originalDocumentLineId) {
        this.originalDocumentLineId = originalDocumentLineId;
    }

    @Override
    public String getTargetDocumentType() {
        return targetDocumentType;
    }

    @Override
    public void setTargetDocumentType(String targetDocumentType) {
        this.targetDocumentType = targetDocumentType;
    }

    @Override
    public Integer getTargetDocumentEntry() {
        return targetDocumentEntry;
    }

    @Override
    public void setTargetDocumentEntry(Integer targetDocumentEntry) {
        this.targetDocumentEntry = targetDocumentEntry;
    }

    @Override
    public Integer getTargetDocumentLineId() {
        return targetDocumentLineId;
    }

    @Override
    public void setTargetDocumentLineId(Integer targetDocumentLineId) {
        this.targetDocumentLineId = targetDocumentLineId;
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
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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
    public String getInventoryUoM() {
        return inventoryUoM;
    }

    @Override
    public void setInventoryUoM(String inventoryUoM) {
        this.inventoryUoM = inventoryUoM;
    }

    @Override
    public String getSerialNumberManagement() {
        return serialNumberManagement;
    }

    @Override
    public void setSerialNumberManagement(String serialNumberManagement) {
        this.serialNumberManagement = serialNumberManagement;
    }

    @Override
    public String getBatchNumberManagement() {
        return batchNumberManagement;
    }

    @Override
    public void setBatchNumberManagement(String batchNumberManagement) {
        this.batchNumberManagement = batchNumberManagement;
    }

    @Override
    public String getServiceNumberManagement() {
        return serviceNumberManagement;
    }

    @Override
    public void setServiceNumberManagement(String serviceNumberManagement) {
        this.serviceNumberManagement = serviceNumberManagement;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public Double getCurrencyRate() {
        return currencyRate;
    }

    @Override
    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }

    @Override
    public Double getLineTotal() {
        return lineTotal;
    }

    @Override
    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    @Override
    public String getFromWarehose() {
        return fromWarehose;
    }

    @Override
    public void setFromWarehose(String fromWarehose) {
        this.fromWarehose = fromWarehose;
    }

    @Override
    public String getFromLocation() {
        return fromLocation;
    }

    @Override
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    @Override
    public String getToWarehouse() {
        return toWarehouse;
    }

    @Override
    public void setToWarehouse(String toWarehouse) {
        this.toWarehouse = toWarehouse;
    }

    @Override
    public String getToLocation() {
        return toLocation;
    }

    @Override
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    @Override
    public String getBatchNumber() {
        return batchNumber;
    }

    @Override
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String getBarCode1() {
        return barCode1;
    }

    @Override
    public void setBarCode1(String barCode1) {
        this.barCode1 = barCode1;
    }

    @Override
    public String getBarCode2() {
        return barCode2;
    }

    @Override
    public void setBarCode2(String barCode2) {
        this.barCode2 = barCode2;
    }

    @Override
    public String getBarCode3() {
        return barCode3;
    }

    @Override
    public void setBarCode3(String barCode3) {
        this.barCode3 = barCode3;
    }

    @Override
    public String getBarCode4() {
        return barCode4;
    }

    @Override
    public void setBarCode4(String barCode4) {
        this.barCode4 = barCode4;
    }

    @Override
    public String getBarCode5() {
        return barCode5;
    }

    @Override
    public void setBarCode5(String barCode5) {
        this.barCode5 = barCode5;
    }


    @Override
    public List<StockReportMaterialItem> getStockReportMaterialItems() {
        return stockReportMaterialItems;
    }

    @Override
    public void setStockReportMaterialItems(List<StockReportMaterialItem> stockReportMaterialItems) {
        this.stockReportMaterialItems = stockReportMaterialItems;
    }

    //public List<>

    public StockReportItem() {
    }

    @Override
    public String toString() {
        return "StockReportItem{" +
                "docEntry=" + docEntry +
                ", lineId=" + lineId +
                ", objectCode='" + objectCode + '\'' +
                ", lineStatus='" + lineStatus + '\'' +
                ", reference1='" + reference1 + '\'' +
                ", reference2='" + reference2 + '\'' +
                ", baseDocumentType='" + baseDocumentType + '\'' +
                ", baseDocumentEntry=" + baseDocumentEntry +
                ", baseDocumentLineId=" + baseDocumentLineId +
                ", projectCode='" + projectCode + '\'' +
                ", distributionRule1='" + distributionRule1 + '\'' +
                ", distributionRule2='" + distributionRule2 + '\'' +
                ", distributionRule3='" + distributionRule3 + '\'' +
                ", distributionRule4='" + distributionRule4 + '\'' +
                ", distributionRule5='" + distributionRule5 + '\'' +
                ", originalDocumentType='" + originalDocumentType + '\'' +
                ", originalDocumentEntry=" + originalDocumentEntry +
                ", originalDocumentLineId=" + originalDocumentLineId +
                ", targetDocumentType='" + targetDocumentType + '\'' +
                ", targetDocumentEntry=" + targetDocumentEntry +
                ", targetDocumentLineId=" + targetDocumentLineId +
                ", itemCode='" + itemCode + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", quantity=" + quantity +
                ", inventoryUoM='" + inventoryUoM + '\'' +
                ", serialNumberManagement='" + serialNumberManagement + '\'' +
                ", batchNumberManagement='" + batchNumberManagement + '\'' +
                ", serviceNumberManagement='" + serviceNumberManagement + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", currencyRate=" + currencyRate +
                ", lineTotal=" + lineTotal +
                ", fromWarehose='" + fromWarehose + '\'' +
                ", fromLocation='" + fromLocation + '\'' +
                ", toWarehouse='" + toWarehouse + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", barCode1='" + barCode1 + '\'' +
                ", barCode2='" + barCode2 + '\'' +
                ", barCode3='" + barCode3 + '\'' +
                ", barCode4='" + barCode4 + '\'' +
                ", barCode5='" + barCode5 + '\'' +
                '}';
    }

    @Override
    public void checkBO(){
        if(getBaseDocumentType() == null || getBaseDocumentType().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_BASEENTRY_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_BASETYPE_IS_NULL);
        }
        if(getLineStatus() ==null || getLineStatus().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_LINESTATUS_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_LINESTATUS_IS_NULL);
        }
    }
}
