package org.edi.stocktask.bo.stockreport;

import org.edi.freamwork.bo.IDocumentBO;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockReport extends IDocumentBO{

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

    String getCreateDate();

    void setCreateDate(String value);


    Integer getCreateTime();

    void setCreateTime(Integer value);

    String getUpdateDate();

    void setUpdateDate(String value);

    Integer getUpdateTime();

    void  setUpdateTime(Integer value);

    String getCreateUserSign();

    void setCreateUserSign(String value);

    String getUpdateUserSign();

    void setUpdateUserSign(String value);

    String getDocumentStatus();

    void setDocumentStatus(String value);

    String getPostingDate();

    void setPostingDate(String value);

    String getDeliveryDate();

    void setDeliveryDate(String value);

    String getDocumentDate();

    void setDocumentDate(String value);

    String getReference1();

    void setReference1(String value);

    String getReference2();

    void setReference2(String value);

    String getRemarks();

    void setRemarks(String value);

    String getB1DocEntry();

    void setB1DocEntry(String value);

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
