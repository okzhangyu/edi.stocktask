package org.edi.stocktask.bo.stockreport;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.bo.DocumentBO;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/27
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockReport extends DocumentBO implements IStockReport{

    private static final String BUSINESS_CODE = "AVA_WM_STOCKREPORT";

    public static StockReport createStockReport(IStockTask stockTask){
        if(stockTask == null) {
            throw new BusinessException(StockOpResultDescription.STOCKTASK_IS_EMPTY);
        }
        if(!StockTaskData.OPEN.equals(stockTask.getDocumentStatus())){
           throw new BusinessException(StockOpResultDescription.STOCKTASK_IS_CLOSE);
        }
        StockReport stockReport = new StockReport();
        stockReport.setRemarks(stockTask.getRemarks());
        stockReport.setCompanyName(stockTask.getCompanyName());
        stockReport.setBusinessPartnerCode(stockTask.getBusinessPartnerCode());
        stockReport.setBusinessPartnerName(stockTask.getBusinessPartnerName());
        stockReport.setObjectCode(stockTask.getObjectCode());
        stockReport.setTransactionType(stockTask.getTransactionType());
        stockReport.setReference1(stockTask.getReference1());
        stockReport.setBaseDocumentEntry(stockTask.getDocumentEntry());
        stockReport.setBaseDocumentType(stockTask.getDocumentType());
        stockReport.setTransactionType(stockTask.getTransactionType());
        stockReport.setDocumentStatus(stockTask.getDocumentStatus());
        stockReport.setDocumentDate(stockTask.getDocumentDate());

        List<StockReportItem> stockReportItemList = new ArrayList<>();
        //TODO 按照文档赋单据表头值
        for (IStockTaskItem item:stockTask.getStockTaskItems()) {
            StockReportItem stockReportItem = new StockReportItem();
            if(StockTaskData.OPEN.equals(item.getLineStatus())){
                //过滤已清的任务行
                //TODO 按照文档赋单据明细值
                stockReportItem.setObjectCode(item.getObjectCode());
                stockReportItem.setReference1(item.getReference1());
                stockReportItem.setReference2(item.getReference2());
                stockReportItem.setBaseDocumentType(item.getDocumentType());
                stockReportItem.setBaseDocumentEntry(item.getDocumentEntry());
                stockReportItem.setBaseDocumentLineId(item.getDocumentLineId());
                stockReportItem.setBatchNumberManagement(item.getBatchNumberManagement());
                stockReportItem.setBaseDocumentEntry(item.getDocumentEntry());
                stockReportItem.setItemCode(item.getItemCode());
                stockReportItem.setQuantity(item.getQuantity());
                stockReportItem.setPrice(item.getPrice());
                stockReportItem.setLineStatus(item.getLineStatus());
                stockReportItem.setItemDescription(item.getItemDescription());
                stockReportItem.setFromLocation(item.getFromLocation());
                stockReportItem.setFromWarehose(item.getFromWarehose());
                stockReportItem.setToLocation(item.getToLocation());
                stockReportItem.setToWarehouse(item.getToWarehouse());


                //stockReportItem.getStockReportMaterialItems()
                stockReportItemList.add(stockReportItem);
            }
        }
        stockReport.setStockReportItems(stockReportItemList);
        return stockReport;
    }
    
    
//    private String companyName;
    private Integer docEntry;
    private Integer docNum;
    private String period;
    private String objectCode;
    private String transfered;
    private String createDate;
    private Integer createTime;
    private String updateDate;
    private Integer updateTime;
    private String createUserSign;
    private String updateUserSign;
    private String documentStatus;
    private String postingDate;
    private String deliveryDate;
    private String documentDate;
    private String reference1;
    private String reference2;
    private String remarks;
    private Integer b1DocEntry;
    private String bydUUID;
    private String customType;
    private String transactionType;
    private String businessPartnerCode;
    private String businessPartnerName;
    private String baseDocumentType;
    private Integer baseDocumentEntry;
    private String targetDocumentType;

    private List<StockReportItem> stockReportItems;


    @Override
    public Integer getDocEntry() {
        return docEntry;
    }

    @Override
    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    @Override
    public Integer getDocNum() {
        return docNum;
    }

    @Override
    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    @Override
    public String getPeriod() {
        return period;
    }

    @Override
    public void setPeriod(String period) {
        this.period = period;
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
    public String getTransfered() {
        return transfered;
    }

    @Override
    public void setTransfered(String transfered) {
        this.transfered = transfered;
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
    public String getCreateUserSign() {
        return createUserSign;
    }

    @Override
    public void setCreateUserSign(String createUserSign) {
        this.createUserSign = createUserSign;
    }

    @Override
    public String getUpdateUserSign() {
        return updateUserSign;
    }

    @Override
    public void setUpdateUserSign(String updateUserSign) {
        this.updateUserSign = updateUserSign;
    }

    @Override
    public String getDocumentStatus() {
        return documentStatus;
    }

    @Override
    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
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
    public Integer getB1DocEntry() {
        return b1DocEntry;
    }

    @Override
    public void setB1DocEntry(Integer b1DocEntry) {
        this.b1DocEntry = b1DocEntry;
    }

    @Override
    public String getBydUUID() {
        return bydUUID;
    }

    @Override
    public void setBydUUID(String bydUUID) {
        this.bydUUID = bydUUID;
    }

    @Override
    public String getCustomType() {
        return customType;
    }

    @Override
    public void setCustomType(String customType) {
        this.customType = customType;
    }

    @Override
    public String getTransactionType() {
        return transactionType;
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
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
    public List<StockReportItem> getStockReportItems() {
        return stockReportItems;
    }

    @Override
    public void setStockReportItems(List<StockReportItem> stockReportItems) {
        this.stockReportItems = stockReportItems;
    }

    @Override
    public boolean isBatchSerialsManagement() {
        return false;
    }

    public StockReport() {
        this.setObjectCode(BUSINESS_CODE);
    }

    @Override
    public String toString() {
        return "{" +
                "companyName:'" + this.getCompanyName() + '\'' +
                ", docEntry:" + docEntry +
                ", docNum:" + docNum +
                ", period:'" + period + '\'' +
                ", objectCode:'" + objectCode + '\'' +
                ", transfered:'" + transfered + '\'' +
                ", createDate:'" + createDate + '\'' +
                ", createTime:" + createTime +
                ", updateDate:'" + updateDate + '\'' +
                ", updateTime:" + updateTime +
                ", createUserSign:'" + createUserSign + '\'' +
                ", updateUserSign:'" + updateUserSign + '\'' +
                ", documentStatus:'" + documentStatus + '\'' +
                ", postingDate:'" + postingDate + '\'' +
                ", deliveryDate:'" + deliveryDate + '\'' +
                ", documentDate:'" + documentDate + '\'' +
                ", reference1:'" + reference1 + '\'' +
                ", reference2:'" + reference2 + '\'' +
                ", remarks:'" + remarks + '\'' +
                ", b1DocEntry:" + b1DocEntry +
                ", bydUUID:'" + bydUUID + '\'' +
                ", customType:'" + customType + '\'' +
                ", targetDocumentType:'" + targetDocumentType + '\'' +
                ", transactionType:'" + transactionType + '\'' +
                ", businessPartnerCode:'" + businessPartnerCode + '\'' +
                ", businessPartnerName:'" + businessPartnerName + '\'' +
                ", baseDocumentType:'" + baseDocumentType + '\'' +
                ", baseDocumentEntry:" + baseDocumentEntry +
                ", stockReportItems:" + stockReportItems +
                '}';
    }

    @Override
    public void checkBO(){
        super.checkBO();
        if(this.baseDocumentType == null || this.baseDocumentType.isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_BASETYPE_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_BASETYPE_IS_NULL);
        }
        if(this.documentStatus == null || this.documentStatus.isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_DOCSTATUS_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_DOCSTATUS_IS_NULL);
        }
        if(this.getObjectCode() == null || this.getObjectCode().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_OBJECTCODE_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_OBJECTCODE_IS_NULL);
        }
       /* if(this.getTargetDocumentType() == null || this.getTargetDocumentType().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_TargetDocumentType_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_TargetDocumentType_IS_NULL);
        }*/
        this.stockReportItems.forEach(c->c.checkBO());
    }
}
