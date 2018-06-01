package org.edi.stocktask.bo.stocktask;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockTaskBarCodeItem {
    Integer getObjectKey();

    void setObjectKey();

    String getObjectCode();

    void setObjectCode();

    Integer getLineId();

    void setLineId(Integer value);

    String getReference1();

    void setReference1(String value);

    String getReference2();

    void setReference2(String value);

    Integer getBaseLineId();

    void setBaseLineId(Integer value);

    String getGrapicCode();

    void setGrapicCode(String value);


}
