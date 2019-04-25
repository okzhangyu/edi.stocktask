package org.edi.stocktask.bo.stockreport;


import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.bo.DocumentBOLine;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.dto.CodeBarParseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fancy
 * @date 2018/5/27
 */
public class StockReportItem extends DocumentBOLine implements IStockReportItem{

    public static List<StockReportItem> createStockReportItemList(List<IStockTaskItem> stockTaskItems, List<CodeBarParseResult> codeBarParseResults){
        List<StockReportItem> stockReportItemList = new ArrayList<>();
        StockReportItem stockReportItem;
        StockReportMaterialItem stockReportMaterialItem;
        for (CodeBarParseResult codeBarParseResult:
             codeBarParseResults) {
            stockReportMaterialItem = StockReportMaterialItem.createMaterialItem(codeBarParseResult);

            //查找与解析结果匹配的任务行信息
            List<IStockTaskItem> taskItem = stockTaskItems.stream()
                    .filter(c-> c.getDocumentLineId().equals(codeBarParseResult.getBaseLine())
                            &&  c.getItemCode().equals(codeBarParseResult.getItemCode()))
                    .collect(Collectors.toList());

            // 解析结果匹配到任务行  根据任务行创建汇报行信息
            if(taskItem != null && taskItem.size() > 0){
                List<StockReportItem> newList = stockReportItemList.stream()
                        .filter(c->c.getBaseDocumentLineId().equals(codeBarParseResult.getBaseLine())
                                && c.getItemCode().equals(codeBarParseResult.getItemCode()))
                        .collect(Collectors.toList());
                // 如果汇报行已经创建，则不用创建
                if(newList != null && newList.size() > 0){
                    stockReportItem = newList.get(0);
                }else {
                    stockReportItem = createStockReportItem(taskItem.get(0));
                    stockReportItemList.add(stockReportItem);
                }
                // 如果该物料为批次/序列号管理，将解析结果添加至孙子表
                if(stockReportItem.getBatchNumberManagement().equals("Y") || stockReportItem.getSerialNumberManagement().equals("Y")){
                    stockReportItem.getStockReportMaterialItems().add(stockReportMaterialItem);
                }

                Double quantity = stockReportItem.getQuantity();
                stockReportItem.setQuantity(quantity + stockReportMaterialItem.getQuantity());
            }else {
                throw new BusinessException(StockOpResultCode.BARCODE_PARSE_RESULT_IS_ERROR,StockOpResultDescription.BARCODE_PARSE_RESULT_IS_ERROR);
            }
        }
        return  stockReportItemList;
    }

    public static StockReportItem createStockReportItem(IStockTaskItem stockTaskItem){
        StockReportItem stockReportItme = new StockReportItem();
        stockReportItme.setBaseDocumentEntry(stockTaskItem.getDocumentEntry());
        stockReportItme.setBaseDocumentType(stockTaskItem.getDocumentType());
        stockReportItme.setBaseDocumentLineId(stockTaskItem.getDocumentLineId());
        stockReportItme.setOriginalDocumentType(stockTaskItem.getBaseDocumentType());
        stockReportItme.setOriginalDocumentEntry(stockTaskItem.getBaseDocumentEntry());
        stockReportItme.setOriginalDocumentLineId(stockTaskItem.getBaseDocumentLineId());
        stockReportItme.setItemCode(stockTaskItem.getItemCode());
        stockReportItme.setItemDescription(stockTaskItem.getItemDescription());
        stockReportItme.setSerialNumberManagement(stockTaskItem.getSerialNumberManagement());
        stockReportItme.setBatchNumberManagement(stockTaskItem.getBatchNumberManagement());
        stockReportItme.setLineStatus(stockTaskItem.getLineStatus());
        stockReportItme.setToLocation(stockTaskItem.getToLocation());
        stockReportItme.setFromLocation(stockTaskItem.getFromLocation());
        stockReportItme.setFromWarehose(stockTaskItem.getFromWarehose());
        stockReportItme.setToWarehouse(stockTaskItem.getToWarehouse());
        stockReportItme.setPrice(stockTaskItem.getPrice());
        stockReportItme.setQuantity(0.0);
        return stockReportItme;
    }

    private Integer docEntry;
    private Integer lineId;
    private String objectCode;
    private String lineStatus;
    private String reference1;
    private String reference2;
    private String baseDocumentType;
    private Integer baseDocumentEntry;
    private Integer baseDocumentLineId;
    private String projectCode;
    private String distributionRule1;
    private String distributionRule2;
    private String distributionRule3;
    private String distributionRule4;
    private String distributionRule5;
    private String originalDocumentType;
    private Integer originalDocumentEntry;
    private Integer originalDocumentLineId;
    private String targetDocumentType;
    private Integer targetDocumentEntry;
    private Integer targetDocumentLineId;
    private String itemCode;
    private String itemDescription;
    private Double quantity;
    private String inventoryUoM;
    private String serialNumberManagement;
    private String batchNumberManagement;
    private String serviceNumberManagement;
    private Double price;
    private String currency;
    private Double currencyRate;
    private Double lineTotal;
    private String fromWarehose;
    private String fromLocation;
    private String toWarehouse;
    private String toLocation;

    private List<StockReportMaterialItem> stockReportMaterialItems;

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
    public String getLineStatus() {
        return lineStatus;
    }

    @Override
    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
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
    public Integer getBaseDocumentLineId() {
        return baseDocumentLineId;
    }

    @Override
    public void setBaseDocumentLineId(Integer baseDocumentLineId) {
        this.baseDocumentLineId = baseDocumentLineId;
    }

    @Override
    public String getProjectCode() {
        return projectCode;
    }

    @Override
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String getDistributionRule1() {
        return distributionRule1;
    }

    @Override
    public void setDistributionRule1(String distributionRule1) {
        this.distributionRule1 = distributionRule1;
    }

    @Override
    public String getDistributionRule2() {
        return distributionRule2;
    }

    @Override
    public void setDistributionRule2(String distributionRule2) {
        this.distributionRule2 = distributionRule2;
    }

    @Override
    public String getDistributionRule3() {
        return distributionRule3;
    }

    @Override
    public void setDistributionRule3(String distributionRule3) {
        this.distributionRule3 = distributionRule3;
    }

    @Override
    public String getDistributionRule4() {
        return distributionRule4;
    }

    @Override
    public void setDistributionRule4(String distributionRule4) {
        this.distributionRule4 = distributionRule4;
    }

    @Override
    public String getDistributionRule5() {
        return distributionRule5;
    }

    @Override
    public void setDistributionRule5(String distributionRule5) {
        this.distributionRule5 = distributionRule5;
    }

    @Override
    public String getOriginalDocumentType() {
        return originalDocumentType;
    }

    @Override
    public void setOriginalDocumentType(String originalDocumentType) {
        this.originalDocumentType = originalDocumentType;
    }

    @Override
    public Integer getOriginalDocumentEntry() {
        return originalDocumentEntry;
    }

    @Override
    public void setOriginalDocumentEntry(Integer originalDocumentEntry) {
        this.originalDocumentEntry = originalDocumentEntry;
    }

    @Override
    public Integer getOriginalDocumentLineId() {
        return originalDocumentLineId;
    }

    @Override
    public void setOriginalDocumentLineId(Integer originalDocumentLineId) {
        this.originalDocumentLineId = originalDocumentLineId;
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
    public Integer getTargetDocumentEntry() {
        return targetDocumentEntry;
    }

    @Override
    public void setTargetDocumentEntry(Integer targetDocumentEntry) {
        this.targetDocumentEntry = targetDocumentEntry;
    }

    @Override
    public Integer getTargetDocumentLineId() {
        return targetDocumentLineId;
    }

    @Override
    public void setTargetDocumentLineId(Integer targetDocumentLineId) {
        this.targetDocumentLineId = targetDocumentLineId;
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
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public Double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getInventoryUoM() {
        return inventoryUoM;
    }

    @Override
    public void setInventoryUoM(String inventoryUoM) {
        this.inventoryUoM = inventoryUoM;
    }

    @Override
    public String getSerialNumberManagement() {
        return serialNumberManagement;
    }

    @Override
    public void setSerialNumberManagement(String serialNumberManagement) {
        this.serialNumberManagement = serialNumberManagement;
    }

    @Override
    public String getBatchNumberManagement() {
        return batchNumberManagement;
    }

    @Override
    public void setBatchNumberManagement(String batchNumberManagement) {
        this.batchNumberManagement = batchNumberManagement;
    }

    @Override
    public String getServiceNumberManagement() {
        return serviceNumberManagement;
    }

    @Override
    public void setServiceNumberManagement(String serviceNumberManagement) {
        this.serviceNumberManagement = serviceNumberManagement;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public Double getCurrencyRate() {
        return currencyRate;
    }

    @Override
    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }

    @Override
    public Double getLineTotal() {
        return lineTotal;
    }

    @Override
    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    @Override
    public String getFromWarehose() {
        return fromWarehose;
    }

    @Override
    public void setFromWarehose(String fromWarehose) {
        this.fromWarehose = fromWarehose;
    }

    @Override
    public String getFromLocation() {
        return fromLocation;
    }

    @Override
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    @Override
    public String getToWarehouse() {
        return toWarehouse;
    }

    @Override
    public void setToWarehouse(String toWarehouse) {
        this.toWarehouse = toWarehouse;
    }

    @Override
    public String getToLocation() {
        return toLocation;
    }

    @Override
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }


    @Override
    public List<StockReportMaterialItem> getStockReportMaterialItems() {
        if(this.stockReportMaterialItems == null){
            this.stockReportMaterialItems = new ArrayList<>();
        }
        return stockReportMaterialItems;
    }

    @Override
    public void setStockReportMaterialItems(List<StockReportMaterialItem> stockReportMaterialItems) {
        this.stockReportMaterialItems =stockReportMaterialItems;
    }

    //public List<>

    public StockReportItem() {
        this.stockReportMaterialItems = new ArrayList<>();
        this.setIsDeleted("N");
    }

    @Override
    public String toString() {
        return "{" +
                "\"docEntry\":\"" + docEntry +
                "\",\"lineId\":\"" + lineId +
                "\",\"objectCode\":\"" + objectCode  +
                "\",\"lineStatus\":\"" + lineStatus  +
                "\",\"reference1\":\"" + reference1  +
                "\",\"reference2\":\"" + reference2  +
                "\",\"baseDocumentType\":\"" + baseDocumentType  +
                "\",\"baseDocumentEntry\":\"" + baseDocumentEntry +
                "\",\"baseDocumentLineId\":\"" + baseDocumentLineId +
                "\",\"projectCode\":\"" + projectCode  +
                "\",\"distributionRule1\":\"" + distributionRule1  +
                "\",\"distributionRule2\":\"" + distributionRule2  +
                "\",\"distributionRule3\":\"" + distributionRule3  +
                "\",\"distributionRule4\":\"" + distributionRule4  +
                "\",\"distributionRule5\":\"" + distributionRule5  +
                "\",\"originalDocumentType\":\"" + originalDocumentType  +
                "\",\"originalDocumentEntry\":\"" + originalDocumentEntry +
                "\",\"originalDocumentLineId\":\"" + originalDocumentLineId +
                "\",\"targetDocumentType\":\"" + targetDocumentType  +
                "\",\"targetDocumentEntry\":\"" + targetDocumentEntry +
                "\",\"targetDocumentLineId\":\"" + targetDocumentLineId +
                "\",\"itemCode\":\"" + itemCode  +
                "\",\"itemDescription\":\"" + itemDescription  +
                "\",\"quantity\":\"" + quantity +
                "\",\"inventoryUoM\":\"" + inventoryUoM  +
                "\",\"serialNumberManagement\":\"" + serialNumberManagement  +
                "\",\"batchNumberManagement\":\"" + batchNumberManagement  +
                "\",\"serviceNumberManagement\":\"" + serviceNumberManagement  +
                "\",\"price\":\"" + price +
                "\",\"currency\":\"" + currency  +
                "\",\"currencyRate\":\"" + currencyRate +
                "\",\"lineTotal\":\"" + lineTotal +
                "\",\"fromWarehose\":\"" + fromWarehose  +
                "\",\"fromLocation\":\"" + fromLocation  +
                "\",\"toWarehouse\":\"" + toWarehouse  +
                "\",\"toLocation\":\"" + toLocation  +
                "\",\"stockReportMaterialItems\":[" + stockReportMaterialItems +
                "]}";
    }

    @Override
    public void checkBO(){
        if(getBaseDocumentType() == null || getBaseDocumentType().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_BASEENTRY_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_BASETYPE_IS_NULL);
        }
        if(getLineStatus() ==null || getLineStatus().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_LINESTATUS_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_LINESTATUS_IS_NULL);
        }
        if(getItemCode() ==null || getItemCode().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_ITEMCODE_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_ITEMCODE_IS_NULL);
        }
        if(getBaseDocumentEntry()<=0){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_BASEENTRY_IS_INVALID,
                    StockOpResultDescription.STOCK_OBJECT_BASEENTRY_IS_INVALID);
        }
        if(getBaseDocumentLineId()==null){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_BASELINE_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_BASELINE_IS_NULL);
        }
        if(getQuantity()<=0){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_QUANTITY_IS_INVALID,
                    StockOpResultDescription.STOCK_OBJECT_QUANTITY_IS_INVALID);
        }
        if(getToWarehouse() ==null || getToWarehouse().isEmpty()){
            throw new BusinessObjectException(StockOpResultCode.STOCK_OBJECT_TOWAREHOUSE_IS_NULL,
                    StockOpResultDescription.STOCK_OBJECT_TOWAREHOUSE_IS_NULL);
        }
        if(stockReportMaterialItems==null || stockReportMaterialItems.size() ==0){
            throw new BusinessException(StockOpResultCode.MATERIALITEM_IS_NULL, StockOpResultDescription.MATERIALITEM_IS_NULL);
        }
        this.stockReportMaterialItems.forEach(c->c.checkBO());
    }
}
