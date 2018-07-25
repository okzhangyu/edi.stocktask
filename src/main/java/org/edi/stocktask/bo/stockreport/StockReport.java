package org.edi.stocktask.bo.stockreport;


import java.util.Date;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/27
 */
public class StockReport implements IStockReport{

    private static final String BUSINESS_CODE = "AVA_WM_STOCKREPORT";

    private String companyName;//yes
    private Integer docEntry;//yes
    private Integer docNum;//yes
    private String period;//yes
    private String objectCode;//yes
    private String transfered;//yes
    private Date createDate;//yes
    private Integer createTime;//yes
    private Date updateDate;//yes
    private Integer updateTime;//yes
    private String createUserSign;//yes
    private String updateUserSign;//yes
    private String documentStatus;//yes
    private Date postingDate;//unsure
    private Date deliveryDate;//unsure
    private Date documentDate;//yes
    private String reference1;//yes
    private String reference2;//yes
    private String remarks;//yes
    private Integer b1DocEntry;//yes
    private String bydUUID;//yes
    private String customType;//yes
    private String transactionType;//yes
    private String businessPartnerCode;//yes
    private String businessPartnerName;//yes
    private String baseDocumentType;//yes
    private Integer baseDocumentEntry;//yes
    private List<StockReportItem> stockReportItems;

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
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
    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(Date updateDate) {
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
    public Date getDocumentDate() {
        return documentDate;
    }

    @Override
    public void setDocumentDate(Date documentDate) {
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

    public StockReport() {
        this.setObjectCode(BUSINESS_CODE);
    }

    public StockReport(String companyName, Integer docEntry, Integer docNum, String period, String objectCode, String transfered, Date createDate, Integer createTime, Date updateDate, Integer updateTime, String createUserSign, String updateUserSign, String documentStatus, Date postingDate, Date deliveryDate, Date documentDate, String reference1, String reference2, String remarks, Integer b1DocEntry, String bydUUID, String customType, String transactionType, String businessPartnerCode, String businessPartnerName, String baseDocumentType, Integer baseDocumentEntry, List<StockReportItem> stockReportItems) {
        this.companyName = companyName;
        this.docEntry = docEntry;
        this.docNum = docNum;
        this.period = period;
        this.objectCode = objectCode;
        this.transfered = transfered;
        this.createDate = createDate;
        this.createTime = createTime;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.createUserSign = createUserSign;
        this.updateUserSign = updateUserSign;
        this.documentStatus = documentStatus;
        this.postingDate = postingDate;
        this.deliveryDate = deliveryDate;
        this.documentDate = documentDate;
        this.reference1 = reference1;
        this.reference2 = reference2;
        this.remarks = remarks;
        this.b1DocEntry = b1DocEntry;
        this.bydUUID = bydUUID;
        this.customType = customType;
        this.transactionType = transactionType;
        this.businessPartnerCode = businessPartnerCode;
        this.businessPartnerName = businessPartnerName;
        this.baseDocumentType = baseDocumentType;
        this.baseDocumentEntry = baseDocumentEntry;
        this.stockReportItems = stockReportItems;
    }

    @Override
    public String toString() {
        return "StockReport{" +
                "companyName='" + companyName + '\'' +
                ", docEntry=" + docEntry +
                ", docNum=" + docNum +
                ", period='" + period + '\'' +
                ", objectCode='" + objectCode + '\'' +
                ", transfered='" + transfered + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createTime=" + createTime +
                ", updateDate='" + updateDate + '\'' +
                ", updateTime=" + updateTime +
                ", createUserSign='" + createUserSign + '\'' +
                ", updateUserSign='" + updateUserSign + '\'' +
                ", documentStatus='" + documentStatus + '\'' +
                ", postingDate='" + postingDate + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", documentDate='" + documentDate + '\'' +
                ", reference1='" + reference1 + '\'' +
                ", reference2='" + reference2 + '\'' +
                ", remarks='" + remarks + '\'' +
                ", b1DocEntry=" + b1DocEntry +
                ", bydUUID='" + bydUUID + '\'' +
                ", customType='" + customType + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", businessPartnerCode='" + businessPartnerCode + '\'' +
                ", businessPartnerName='" + businessPartnerName + '\'' +
                ", baseDocumentType='" + baseDocumentType + '\'' +
                ", baseDocumentEntry=" + baseDocumentEntry +
                ", stockReportItems=" + stockReportItems +
                '}';
    }
}
