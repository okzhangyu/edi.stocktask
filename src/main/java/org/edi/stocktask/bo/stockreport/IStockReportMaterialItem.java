package org.edi.stocktask.bo.stockreport;

import org.edi.freamwork.bo.IDocumentBOLine;

public interface IStockReportMaterialItem  extends IDocumentBOLine {
    Integer getDocEntry();

    void setDocEntry(Integer value);

    Integer getLineId();

    void setLineId(Integer value);

    String getObjectCode();

    void  setObjectCode(String value);

    String getItemCode();

    void setItemCode(String value);


    Double getQuantity();

    void setQuantity(Double value);

    String getBatchNumber();

    void setBatchNumber(String value);

    String getSerialNumber();

    void setSerialNumber(String value);

    String getBarCode();

    void setBarCode(String value);
}
