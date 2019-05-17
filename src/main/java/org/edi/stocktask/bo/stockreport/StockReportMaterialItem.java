package org.edi.stocktask.bo.stockreport;

import org.edi.freamwork.bo.DocumentBOLine;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.dto.CodeBarParseResult;

public class StockReportMaterialItem extends DocumentBOLine implements IStockReportMaterialItem {

    public static StockReportMaterialItem createMaterialItem(CodeBarParseResult codeBarParseResult){
        StockReportMaterialItem stockReportMaterialItem = new StockReportMaterialItem();
        stockReportMaterialItem.setBarCode(codeBarParseResult.getCodeBar());
        stockReportMaterialItem.setQuantity(codeBarParseResult.getQuantity());
        stockReportMaterialItem.setItemCode(codeBarParseResult.getItemCode());
        stockReportMaterialItem.setBatchNumber(codeBarParseResult.getBatchNum());
        stockReportMaterialItem.setSerialNumber(codeBarParseResult.getSerialNum());
        stockReportMaterialItem.setInDate(codeBarParseResult.getInDate());
        stockReportMaterialItem.setExpDate(codeBarParseResult.getExpDate());
        stockReportMaterialItem.setPrdDate(codeBarParseResult.getPrdDate());
        stockReportMaterialItem.setRemarks(codeBarParseResult.getRemarks());
        stockReportMaterialItem.setIsDeleted("N");
        return  stockReportMaterialItem;
    }

    private Integer docEntry;
    private Integer lineId;
    private String objectCode;
    private String itemCode;
    private String batchNumber;
    private String serialNumber;
    private String barCode;
    private Double quantity;
    private String inDate;
    private String expDate;
    private String remarks;
    private String prdDate;

    @Override
    public Integer getDocEntry() {
        return docEntry;
    }

    @Override
    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    @Override
    public Integer getLineId() {
        return lineId;
    }

    @Override
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
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
    public String getItemCode() {
        return itemCode;
    }

    @Override
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


    @Override
    public String getBatchNumber() {
        return batchNumber;
    }

    @Override
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String getBarCode() {
        return barCode;
    }

    @Override
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String getInDate() {
        return inDate;
    }

    @Override
    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    @Override
    public String getExpDate() {
        return expDate;
    }

    @Override
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String getPrdDate() {
        return prdDate;
    }

    @Override
    public void setPrdDate(String prdDate) {
        this.prdDate = prdDate;
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
    public Double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }


    public StockReportMaterialItem() {
    }

    @Override
    public void checkBO(){

    }

    @Override
    public String toString() {
        return "StockReportMaterialItem{" +
                "docEntry=" + docEntry +
                ", lineId=" + lineId +
                ", objectCode='" + objectCode + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", barCode='" + barCode + '\'' +
                ", quantity=" + quantity +
                ", inDate='" + inDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", prdDate='" + prdDate + '\'' +
                ", remarks='" + remarks + '\'' +
                "} " + super.toString();
    }
}
