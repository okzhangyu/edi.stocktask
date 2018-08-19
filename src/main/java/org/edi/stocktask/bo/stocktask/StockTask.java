package org.edi.stocktask.bo.stocktask;

import org.edi.freamwork.bo.DocumentBO;
import org.edi.stocktask.data.StockTaskData;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/27
 */
public class StockTask extends DocumentBO implements IStockTask{

    private static final String BUSINESS_CODE = "AVA_WM_STOCKTASK";

    private String companyName;
    private Integer objectKey;
    private String objectCode;
    private String createDate;
    private Integer createTime;
    private String updateDate;
    private Integer updateTime;
    private String reference1;
    private String reference2;
    private String remarks;
    private String documentType;
    private String documentStatus;
    private Integer documentEntry;
    private Integer documentLineId;
    private String businessPartnerCode;
    private String businessPartnerName;
    private String transactionType;
    private String postingDate;
    private String deliveryDate;
    private String documentDate;
    private String schemaCode;
    private String annotated;
    private List<IStockTaskItem> stockTaskItems;
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
    public String getDocumentStatus() {
        return this.documentStatus;
    }

    @Override
    public void setDocumentStatus(String value) {
        this.documentStatus = value;
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
    public String getPostingDate() {
        return postingDate;
    }

    @Override
    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    @Override
    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public void setDeliveryDate(String deliveryDate) {
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
    public List<IStockTaskItem> getStockTaskItems() {
        return stockTaskItems;
    }

    @Override
    public void setStockTaskItems(List<IStockTaskItem> stockTaskItems) {
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

    @Override
    public String toString() {
        return "StockTask{" +
                "companyName='" + companyName + '\'' +
                ", objectKey=" + objectKey +
                ", objectCode='" + objectCode + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createTime=" + createTime +
                ", updateDate='" + updateDate + '\'' +
                ", updateTime=" + updateTime +
                ", reference1='" + reference1 + '\'' +
                ", reference2='" + reference2 + '\'' +
                ", remarks='" + remarks + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentEntry=" + documentEntry +
                ", documentLineId=" + documentLineId +
                ", businessPartnerCode='" + businessPartnerCode + '\'' +
                ", businessPartnerName='" + businessPartnerName + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", postingDate=" + postingDate +
                ", deliveryDate=" + deliveryDate +
                ", documentDate='" + documentDate + '\'' +
                ", schemaCode='" + schemaCode + '\'' +
                ", annotated='" + annotated + '\'' +
                ", stockTaskItems=" + stockTaskItems +
                ", stockTaskBarCodeItems=" + stockTaskBarCodeItems +
                '}';
    }

    @Override
    public void initDocStatus(){
        if(this.getStockTaskItems() == null){
            return;
        }
        Integer itemCloseCount = 0;
        for (int index = 0;index<this.getStockTaskItems().size();index++){
            if(StockTaskData.CLOSE.equals(this.getStockTaskItems().get(index).getLineStatus())){
                itemCloseCount ++;
            }
            if(itemCloseCount > 0 && itemCloseCount <= index){
                break;
            }
        }
        if(itemCloseCount == this.getStockTaskItems().size()){
            this.setDocumentStatus(StockTaskData.CLOSE);
        }else if(itemCloseCount >0 && itemCloseCount < this.getStockTaskItems().size()){
            this.setDocumentStatus(StockTaskData.PARTIAL);
        }
    }
}
