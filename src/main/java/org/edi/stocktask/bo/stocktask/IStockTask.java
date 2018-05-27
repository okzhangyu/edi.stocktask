package org.edi.stocktask.bo.stocktask;

import java.util.Date;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockTask {

    String getComanyName();

    void setCompanyName(String value);

    Integer getObjectKey();

    void setObjectKey(Integer value);

    String getObjectCode();

    void setObjectCode(String value);

    Date getCreateDate();

    void setCreateDate(Date value);

    Integer getCreateTime();

    void  setCreateTime(Integer value);

    Date getUpdateDate();

    void setUpdateDate(Date value);

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

    Integer getDocumentEntry();

    void setDocumentEntry(Integer value);

    Integer getDocumentLineId();

    void setDocumentLineId(Integer valua);

    String getBusinessPartnerCode();

    void setBusinessPartnerCode();

    String getBusinessPartnerName();

    void setBusinessPartnerName(String value);

    String getTransactionType();

    void setTransactionType();

    Date getPostingDate();

    void setPostingDate(Date value);

    Date getDeliveryDate();

    void setDeliveryDate(Date value);

    Date getDocumentDate();

    void setDocumentDate(Date value);

    String getSchemaCode();

    void setSchemaCode(String value);

    List<IStockTaskItem> getStockTaskItems();

    void setStockTaskItems(List<IStockTaskItem> value);

    List<IStockTaskBarCodeItem> getStockTaskBarCodeItems();

    void setStockTaskBarCodeItems(List<IStockTaskBarCodeItem> value);
}
