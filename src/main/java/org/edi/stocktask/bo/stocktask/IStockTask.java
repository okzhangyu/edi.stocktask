package org.edi.stocktask.bo.stocktask;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockTask {

    String getCompanyName();

    void setCompanyName(String value);

    Integer getObjectKey();

    void setObjectKey(Integer value);

    String getObjectCode();

    void setObjectCode(String value);

    String getCreateDate();

    void setCreateDate(String value);

    Integer getCreateTime();

    void  setCreateTime(Integer value);

    String getUpdateDate();

    void setUpdateDate(String value);

    Integer getUpdateTime();

    void setUpdateTime(Integer value);

    String getReference1();

    void setReference1(String value);

    String getReference2();

    void setReference2(String value);

    String getRemarks();

    void setRemarks(String value);

    String getDocumentType();

    void setDocumentType(String value);

    String getDocumentStatus();

    void setDocumentStatus(String value);

    Integer getDocumentEntry();

    void setDocumentEntry(Integer value);

    Integer getDocumentLineId();

    void setDocumentLineId(Integer valua);

    String getBusinessPartnerCode();

    void setBusinessPartnerCode(String value);

    String getBusinessPartnerName();

    void setBusinessPartnerName(String value);

    String getTransactionType();

    void setTransactionType(String value);

    String getPostingDate();

    void setPostingDate(String value);

    String getDeliveryDate();

    void setDeliveryDate(String value);

    String getDocumentDate();

    void setDocumentDate(String value);

    String getSchemaCode();

    void setSchemaCode(String value);

     String getAnnotated();

    void setAnnotated(String annotated);

    List<StockTaskItem> getStockTaskItems();

    void setStockTaskItems(List<StockTaskItem> value);

    List<IStockTaskBarCodeItem> getStockTaskBarCodeItems();

    void setStockTaskBarCodeItems(List<IStockTaskBarCodeItem> value);
}
