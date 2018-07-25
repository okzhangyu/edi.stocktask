package org.edi.stocktask.bo.stockreport;

import java.util.Date;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReport {

    String getCompanyName();

    void setCompanyName(String value);

    Integer getDocEntry();

    void setDocEntry(Integer value);

    Integer getDocNum();

    void setDocNum(Integer value);

    String getPeriod();

    void setPeriod(String value);

    String getObjectCode();

    void setObjectCode(String value);

    String getTransfered();

    void setTransfered(String value);

    Date getCreateDate();

    void setCreateDate(Date value);

    Integer getCreateTime();

    void setCreateTime(Integer value);

    Date getUpdateDate();

    void setUpdateDate(Date value);

    Integer getUpdateTime();

    void  setUpdateTime(Integer value);

    String getCreateUserSign();

    void setCreateUserSign(String value);

    String getUpdateUserSign();

    void setUpdateUserSign(String value);

    String getDocumentStatus();

    void setDocumentStatus(String value);

    Date getPostingDate();

    void setPostingDate(Date value);

    Date getDeliveryDate();

    void setDeliveryDate(Date value);

    Date getDocumentDate();

    void setDocumentDate(Date value);

    String getReference1();

    void setReference1(String value);

    String getReference2();

    void setReference2(String value);

    String getRemarks();

    void setRemarks(String value);

    Integer getB1DocEntry();

    void setB1DocEntry(Integer value);

    String getBydUUID();

    void setBydUUID(String value);

    String getCustomType();


    void setCustomType(String value );

    String getTransactionType();

    void setTransactionType(String value);

    String getBusinessPartnerCode();

    void setBusinessPartnerCode(String value);

    String getBusinessPartnerName();

    void setBusinessPartnerName(String value);

    String getBaseDocumentType();

    void setBaseDocumentType(String value);

    Integer getBaseDocumentEntry();

    void setBaseDocumentEntry(Integer value);

    List<StockReportItem> getStockReportItems();

    void setStockReportItems(List<StockReportItem> value);


}
