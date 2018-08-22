package org.edi.stocktask.bo.stocktask;

import org.edi.freamwork.bo.DocumentBOLine;

/**
 * @author Fancy
 * @date 2018/5/27
 */
public class StockTaskItem extends DocumentBOLine implements IStockTaskItem{

    private Integer objectKey;
    private String objectCode;
    private Integer lineId;
    private String lineStatus;
    private String reference1;
    private String reference2;
    private String documentType;
    private Integer documentEntry;
    private Integer documentLineId;
    private String itemCode;
    private String itemDescription;
    private Double packageQuantity;
    private Double quantity;
    private Double openQuantity;
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
    private String transactionType;
    private String baseDocumentType;
    private Integer baseDocumentEntry;
    private Integer baseDocumentLineId;
    private String originalDocumentType;
    private Integer originalDocumentEntry;
    private Integer originalDocumentLineId;
    private String scanningType;
    private String waterCode;

    @Override
    public Integer getObjectKey() {
        return objectKey;
    }

    @Override
    public void setObjectKey(Integer objectKey) {
        this.objectKey = objectKey;
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
    public Integer getLineId() {
        return lineId;
    }

    @Override
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
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
    public String getDocumentType() {
        return documentType;
    }

    @Override
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public Integer getDocumentEntry() {
        return documentEntry;
    }

    @Override
    public void setDocumentEntry(Integer documentEntry) {
        this.documentEntry = documentEntry;
    }

    @Override
    public Integer getDocumentLineId() {
        return documentLineId;
    }

    @Override
    public void setDocumentLineId(Integer documentLineId) {
        this.documentLineId = documentLineId;
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
    public Double getPackageQuantity() {
        return packageQuantity;
    }

    @Override
    public void setPackageQuantity(Double packageQuantity) {
        this.packageQuantity = packageQuantity;
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
    public Double getOpenQuantity() {
        return this.openQuantity;
    }

    @Override
    public void setOpenQuantity(Double value) {
        this.openQuantity = value;
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
    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
    public String getScanningType() {
        return scanningType;
    }

    @Override
    public void setScanningType(String scanningType) {
        this.scanningType = scanningType;
    }

    @Override
    public String getWaterCode() {
        return waterCode;
    }

    @Override
    public void setWaterCode(String waterCode) {
        this.waterCode = waterCode;
    }


    public StockTaskItem() {

    }

    @Override
    public String toString() {
        return "{" +
                "objectKey:" + objectKey +
                ", objectCode:'" + objectCode + '\'' +
                ", lineId:" + lineId +
                ", lineStatus:'" + lineStatus + '\'' +
                ", reference1:'" + reference1 + '\'' +
                ", reference2:'" + reference2 + '\'' +
                ", documentType:'" + documentType + '\'' +
                ", documentEntry:" + documentEntry +
                ", documentLineId:" + documentLineId +
                ", itemCode:'" + itemCode + '\'' +
                ", itemDescription:'" + itemDescription + '\'' +
                ", packageQuantity:" + packageQuantity +
                ", quantity:" + quantity +
                ", openQuantity:" + openQuantity +
                ", inventoryUoM:'" + inventoryUoM + '\'' +
                ", serialNumberManagement:'" + serialNumberManagement + '\'' +
                ", batchNumberManagement:'" + batchNumberManagement + '\'' +
                ", serviceNumberManagement:'" + serviceNumberManagement + '\'' +
                ", price:" + price +
                ", currency:'" + currency + '\'' +
                ", currencyRate:" + currencyRate +
                ", lineTotal:" + lineTotal +
                ", fromWarehose:'" + fromWarehose + '\'' +
                ", fromLocation:'" + fromLocation + '\'' +
                ", toWarehouse:'" + toWarehouse + '\'' +
                ", toLocation:'" + toLocation + '\'' +
                ", transactionType:'" + transactionType + '\'' +
                ", baseDocumentType:'" + baseDocumentType + '\'' +
                ", baseDocumentEntry:" + baseDocumentEntry +
                ", baseDocumentLineId:" + baseDocumentLineId +
                ", originalDocumentType:'" + originalDocumentType + '\'' +
                ", originalDocumentEntry:" + originalDocumentEntry +
                ", originalDocumentLineId:" + originalDocumentLineId +
                ", scanningType:'" + scanningType + '\'' +
                ", waterCode:'" + waterCode + '\'' +
                '}';
    }
}
