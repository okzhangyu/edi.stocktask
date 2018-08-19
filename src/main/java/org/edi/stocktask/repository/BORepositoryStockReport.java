package org.edi.stocktask.repository;

import org.edi.freamwork.bo.BusinessObject;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.freamwork.repository.BORepository;
import org.edi.freamwork.transcation.TranscationResult;
import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.bo.stockreport.StockReportMaterialItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.mapper.StockReportMapper;
import org.edi.stocktask.mapper.TranscationNoticeMapper;
import org.edi.stocktask.util.B1DocEntryVerification;
import org.edi.stocktask.util.ReportVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */


@Component(value="boRepositoryStockReport")
public class BORepositoryStockReport extends BORepository<StockReport> implements IBORepositoryStockReport{

    @Autowired
    private StockReportMapper stockReportMapper;

    @Autowired
    private B1DocEntryVerification b1DocEntryVerification;

    @Autowired
    private PlatformTransactionManager ptm;

    @Autowired
    private TranscationNoticeMapper transcationNoticeMapper;



    /**
     * 查询任务汇报清单
     * @return
     */

    public List<StockReport> fetchStockReport(String param,int beginIndex,int limit){
        List<StockReport> stockReports;
        try{
            if(param!=null && !param.isEmpty()){
                HashMap<String,Object> params = new HashMap<>();
                params.put("value",param);
                params.put("beginIndex",beginIndex);
                params.put("limit",limit);
                stockReports = stockReportMapper.fetchStockReportFuzzyByPage(params);
            }else {
                stockReports = stockReportMapper.fetchStockReportByPage(beginIndex,limit);
            }
            if(stockReports.size() == 0) {
                return stockReports;
            }
            for(int i=0;i<stockReports.size();i++){
                StockReport stockReport = stockReports.get(i);
                List<StockReportItem> stockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
                for (int j=0;j<stockReportItems.size();j++){
                    StockReportItem stockReportItem = stockReportItems.get(j);
                    List<StockReportMaterialItem> stockReportMaterialItemList= stockReportMapper.fetchStockReportMaterialItem(stockReportItem.getDocEntry(),stockReportItem.getLineId());
                    stockReportItem.setStockReportMaterialItems(stockReportMaterialItemList);
                }
                stockReport.setStockReportItems(stockReportItems);
            }
            return stockReports;
        }catch (Exception e){
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }




    /**
     * 根据DOCENTRY查询库存任务汇报
     * @param docEntry
     * @return
     */
    @Override
    public StockReport fetchStockReport(Integer docEntry){
        StockReport stockReport = stockReportMapper.fetchStockReportByEntry(docEntry);
        List<StockReportItem> stockReportItems = stockReportMapper.fetchStockReportItem(docEntry);
        for(StockReportItem stockReportItem:stockReportItems){
          List<StockReportMaterialItem> stockReportMaterialItemList = stockReportMapper.fetchStockReportMaterialItem(stockReportItem.getDocEntry(),stockReportItem.getLineId());
            stockReportItem.setStockReportMaterialItems(stockReportMaterialItemList);
        }
        stockReport.setStockReportItems(stockReportItems);
        return stockReport;
    }

    /**
     * 获取未清任务汇报
     * @return
     */
    @Override
    public List<StockReport> fetchUnSyncStockReport() {
        List<StockReport> stockReports;
        List<StockReportItem> stockReportItems;
        try{
            stockReports = stockReportMapper.fetchUnSyncStockReport();
            if(stockReports != null && stockReports.size() > 0){
                for(int i=0;i<stockReports.size();i++){
                    IStockReport stockReport = stockReports.get(i);
                    stockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
                    for(StockReportItem stockReportItem:stockReportItems){
                        List<StockReportMaterialItem> stockReportMaterialItemList = stockReportMapper.fetchStockReportMaterialItem(stockReportItem.getDocEntry(),stockReportItem.getLineId());
                        stockReportItem.setStockReportMaterialItems(stockReportMaterialItemList);
                    }
                    stockReport.setStockReportItems(stockReportItems);
                }
            }
        }catch (DBException e){
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
        return stockReports;
    }

    /**
     * 更新单据状态
     * @param stockReport
     */
    @Override
    public void updateStockReportDocStatus(StockReport stockReport) {
        stockReportMapper.updateStockReportDocStatus(stockReport);
    }

    /**
     * 保存任务汇报
     * @param stockReport
     * @return
     */
    @Override
    public void saveStockReport(StockReport stockReport) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;
        try {
            status = ptm.getTransaction(def);
            super.saveBO(stockReport);
            ptm.commit(status);
        }catch (BusinessException ex){
            ptm.rollback(status);
            throw ex;
        }catch (Exception e) {
            if(status != null){
                ptm.rollback(status);
            }
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }


    /**
     * 更新库存任务汇报
     * @param stockReport
     * @return
     */
    @Override
    public void updateStockReport(StockReport stockReport) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;
        try {
            status = ptm.getTransaction(def);
            super.updateBO(stockReport);
            ptm.commit(status);
        } catch (BusinessException ex){
            ptm.rollback(status);
            throw ex;
        }catch (Exception e) {
            if(status != null){
                ptm.rollback(status);
            }
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }


    /**
     * 删除任务汇报
     * @param docEntry
     * @return
     */
    @Override
    public void deleteStockReport(Integer docEntry) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status =null;
        try {
            status = ptm.getTransaction(def);
            if(!b1DocEntryVerification.B1EntryCheck(docEntry)){
                throw new BusinessException(StockOpResultCode.B1DOCENTRY_IS_EXISTENT, StockOpResultDescription.B1DOCENTRY_IS_EXISTENT);
            }
            stockReportMapper.deleteStockReport(docEntry);
            stockReportMapper.deleteStockReportItem(docEntry);
            stockReportMapper.deleteStockReportMaterialItem(docEntry);
            StockReport stockReport = new StockReport();
            stockReport.setDocEntry(docEntry);
            callTranscation(stockReport,"D");
            ptm.commit(status);
        }catch (BusinessException e){
            ptm.rollback(status);
            throw e;
        }catch (Exception e){
            if(status != null){
                ptm.rollback(status);
            }
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }


    @Override
    public void deleteStockReport(StockReport stockReport){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = ptm.getTransaction(def);
        try {
            super.deleteBO(stockReport);
            ptm.commit(status);
        } catch (BusinessException ex){
            ptm.rollback(status);
            throw ex;
        } catch(Exception e){
            if(status != null){
                ptm.rollback(status);
            }
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }

    /**
     * 条件查询任务汇报
     * @param companyName
     * @param baseDocumentType
     * @param baseDocumentEntry
     * @return
     *
     */
    @Override
    public List<StockReport> fetchStockReportByCondition(String companyName, String baseDocumentType, String baseDocumentEntry) {
        HashMap<String,String> stockReportCondition = new HashMap<>();
        stockReportCondition.put("companyName",companyName);
        stockReportCondition.put("baseDocumentType",baseDocumentType);
        stockReportCondition.put("baseDocumentEntry",baseDocumentEntry);
        try{
            List<StockReport> StockReports = stockReportMapper.fetchStockReportByCondition(stockReportCondition);
            for(int i=0;i<StockReports.size();i++){
                StockReport stockReport = StockReports.get(i);
                List<StockReportItem> StockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
                for(StockReportItem stockReportItem:StockReportItems){
                    List<StockReportMaterialItem> stockReportMaterialItemList = stockReportMapper.fetchStockReportMaterialItem(stockReportItem.getDocEntry(),stockReportItem.getLineId());
                    stockReportItem.setStockReportMaterialItems(stockReportMaterialItemList);
                }
                stockReport.setStockReportItems(StockReportItems);
            }
            return StockReports;
        }catch (Exception e){
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }


    /**
     * 模糊查询库存任务汇报
     * @param value
     * @return
     */
    @Override
    public List<StockReport> fetchStockReportFuzzy(String value){
        try {
            List<StockReport> StockReports = stockReportMapper.fetchStockReportFuzzy(value);
            for(int i=0;i<StockReports.size();i++){
                StockReport stockReport = StockReports.get(i);
                List<StockReportItem> StockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
                for(StockReportItem stockReportItem:StockReportItems){
                    List<StockReportMaterialItem> stockReportMaterialItemList = stockReportMapper.fetchStockReportMaterialItem(stockReportItem.getDocEntry(),stockReportItem.getLineId());
                    stockReportItem.setStockReportMaterialItems(stockReportMaterialItemList);
                }
                stockReport.setStockReportItems(StockReportItems);
            }
            return StockReports;
        }catch (Exception e){
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }


    @Override
    protected void save(StockReport stockReport) {
        int docEntry;
        if (stockReport.getDocEntry() == null) {
            docEntry = stockReportMapper.fetchSequenceOfDocEntry();
            stockReport.setDocEntry(docEntry);
        } else {
            docEntry = stockReport.getDocEntry();
        }

        DateFormat df = DateFormat.getDateTimeInstance();
        String nowDate = df.format(new Date());
        if (stockReport.getCreateDate() == null) {
            stockReport.setCreateDate(nowDate);
        } else {
            stockReport.setUpdateDate(nowDate);
        }
        stockReportMapper.saveStockReport(stockReport);
        for (int i = 0;i< stockReport.getStockReportItems().size(); i++) {
            StockReportItem stockReportItem = stockReport.getStockReportItems().get(i);
            stockReportItem.setDocEntry(docEntry);
            stockReportItem.setLineId(i + 1);
            stockReportMapper.saveStockReportItem(stockReportItem);
            ReportVerification.materialItemCheck(stockReportItem.getStockReportMaterialItems());
            for (int j=0;j<stockReportItem.getStockReportMaterialItems().size();j++){
                StockReportMaterialItem stockReportMaterialItem = stockReportItem.getStockReportMaterialItems().get(j);
                stockReportMaterialItem.setDocEntry(docEntry);
                stockReportMaterialItem.setLineId(stockReportItem.getLineId());
                if(stockReportMaterialItem.getBarCode()==null||stockReportMaterialItem.getBarCode().equals("")){
                    throw new BusinessException(StockOpResultCode.CODEBAR_IS_NULL,StockOpResultDescription.CODEBAR_IS_NULL);
                }
                stockReportMapper.saveStockReportMaterialItem(stockReportMaterialItem);
            }
        }
    }

    @Override
    protected void update(StockReport stockReport) {
        if (!b1DocEntryVerification.B1EntryCheck(stockReport.getDocEntry())) {
            throw new BusinessException(StockOpResultCode.B1DOCENTRY_IS_EXISTENT,StockOpResultDescription.B1DOCENTRY_IS_EXISTENT);
        }
        stockReportMapper.updateStockReport(stockReport);
        for (int j = 0; j < stockReport.getStockReportItems().size(); j++) {
            StockReportItem stockReportItem = stockReport.getStockReportItems().get(j);
            stockReportMapper.updateStockReportItem(stockReportItem);
        }
    }


    @Override
    protected void delete(StockReport stockReport) {
        if (!b1DocEntryVerification.B1EntryCheck(stockReport.getDocEntry())) {
            throw new BusinessException(StockOpResultCode.B1DOCENTRY_IS_EXISTENT,StockOpResultDescription.B1DOCENTRY_IS_EXISTENT);
        }
        stockReportMapper.deleteStockReport(stockReport.getDocEntry());
        stockReportMapper.deleteStockReportItem(stockReport.getDocEntry());
        stockReportMapper.deleteStockReportMaterialItem(stockReport.getDocEntry());

    }

    @Override
    protected void callTranscation(StockReport bo, String transType) {
        HashMap<String,String> transParam = new HashMap<>();
        transParam.put("object_type",bo.getObjectCode());
        transParam.put("transaction_type",transType);
        transParam.put("num_of_cols_in_key","1");
        transParam.put("list_of_key_cols_tab_del","DocEntry");
        transParam.put("list_of_cols_val_tab_del",bo.getDocEntry().toString());

        TranscationResult result = transcationNoticeMapper.callTranscationNotice(transParam);
        if(!result.getErrorCode().equals("0")){
            throw new BusinessObjectException(result.getErrorCode(), result.getMessage());
        }
    }
}