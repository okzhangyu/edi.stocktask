package org.edi.stocktask.bo.stocktask;

import java.util.Date;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/27
 */
public class StockTask implements  IStockTask{

    private static final String BUSINESS_CODE = "AVA_WM_STOCKTASK";

    private String companyName;//yes
    private Integer objectKey;//yes
    private String objectCode;
    private String createDate;//yes
    private Integer createTime;
    private String updateDate;//yes
    private Integer updateTime;
    private String reference1;//yes
    private String reference2;//yes
    private String remarks;//yes
    private String documentType;//yes
    private Integer documentEntry;//yes
    private Integer documentLineId;
    private String businessPartnerCode;
    private String businessPartnerName;
    private String transactionType;//yes
    private Date postingDate;
    private Date deliveryDate;
    private String documentDate;//yes
    private String schemaCode;
    private String annotated;//yes
    private List<StockTaskItem> stockTaskItems;
    private List<IStockTaskBarCodeItem> stockTaskBarCodeItems;

    @Override
    public String getCompanyName() {
        return companyName;
}

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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
    public String getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public Integer getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public Integer getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
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
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    public String getBusinessPartnerCode() {
        return businessPartnerCode;
    }

    @Override
    public void setBusinessPartnerCode(String businessPartnerCode) {
        this.businessPartnerCode = businessPartnerCode;
    }

    @Override
    public String getBusinessPartnerName() {
        return businessPartnerName;
    }

    @Override
    public void setBusinessPartnerName(String businessPartnerName) {
        this.businessPartnerName = businessPartnerName;
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
    public Date getPostingDate() {
        return postingDate;
    }

    @Override
    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    @Override
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getDocumentDate() {
        return documentDate;
    }

    @Override
    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    @Override
    public String getSchemaCode() {
        return schemaCode;
    }

    @Override
    public void setSchemaCode(String schemaCode) {
        this.schemaCode = schemaCode;
    }
    @Override
    public String getAnnotated() {
        return annotated;
    }

    @Override
    public void setAnnotated(String annotated) {
        this.annotated = annotated;
    }

    @Override
    public List<StockTaskItem> getStockTaskItems() {
        return stockTaskItems;
    }

    @Override
    public void setStockTaskItems(List<StockTaskItem> stockTaskItems) {
        this.stockTaskItems = stockTaskItems;
    }

    @Override
    public List<IStockTaskBarCodeItem> getStockTaskBarCodeItems() {
        return stockTaskBarCodeItems;
    }

    @Override
    public void setStockTaskBarCodeItems(List<IStockTaskBarCodeItem> stockTaskBarCodeItems) {
        this.stockTaskBarCodeItems = stockTaskBarCodeItems;
    }

    public StockTask() {
        this.setObjectCode(BUSINESS_CODE);
    }

    public StockTask(String companyName, Integer objectKey, String objectCode, String createDate, Integer createTime, String updateDate, Integer updateTime, String reference1, String reference2, String remarks, String documentType, Integer documentEntry, Integer documentLineId, String businessPartnerCode, String businessPartnerName, String transactionType, Date postingDate, Date deliveryDate, String documentDate, String schemaCode, String annotated, List<StockTaskItem> stockTaskItems, List<IStockTaskBarCodeItem> stockTaskBarCodeItems) {
        this.companyName = companyName;
        this.objectKey = objectKey;
        this.objectCode = objectCode;
        this.createDate = createDate;
        this.createTime = createTime;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.reference1 = reference1;
        this.reference2 = reference2;
        this.remarks = remarks;
        this.documentType = documentType;
        this.documentEntry = documentEntry;
        this.documentLineId = documentLineId;
        this.businessPartnerCode = businessPartnerCode;
        this.businessPartnerName = businessPartnerName;
        this.transactionType = transactionType;
        this.postingDate = postingDate;
        this.deliveryDate = deliveryDate;
        this.documentDate = documentDate;
        this.schemaCode = schemaCode;
        this.annotated = annotated;
        this.stockTaskItems = stockTaskItems;
        this.stockTaskBarCodeItems = stockTaskBarCodeItems;
    }


    public StockTask(String companyName, Integer objectKey, String createDate,String updateDate, String reference1, String reference2, String remarks, String documentType, Integer documentEntry,String transactionType, String documentDate, String annotated) {
        this.companyName = companyName;
        this.objectKey = objectKey;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.reference1 = reference1;
        this.reference2 = reference2;
        this.remarks = remarks;
        this.documentType = documentType;
        this.documentEntry = documentEntry;
        this.transactionType = transactionType;
        this.documentDate = documentDate;
        this.annotated = annotated;
    }




}
