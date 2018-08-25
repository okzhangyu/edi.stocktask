package org.edi.stocktask.repository;

import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.freamwork.repository.BORepository;
import org.edi.freamwork.transcation.TranscationResult;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.mapper.UserMapper;
import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.bo.stockreport.StockReportMaterialItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.mapper.StockReportMapper;
import org.edi.stocktask.mapper.TranscationNoticeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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

    Logger logger = LoggerFactory.getLogger(BORepositoryStockReport.class);
    @Autowired
    private StockReportMapper stockReportMapper;


    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private PlatformTransactionManager ptm;

    @Autowired
    private TranscationNoticeMapper transcationNoticeMapper;


    /**
     * 查询库存汇报清单
     * @return
     */

    public List<StockReport> fetchStockReport(String token,String fluzzyParam,int beginIndex,int limit,List<String> docStatus) {
        List<StockReport> stockReports;
        try {
            User user = userMapper.getUserByToken(token);
            HashMap<String, Object> params = new HashMap<>();
            if(!user.getIsSupperUser().toUpperCase().equals(StockTaskData.YES)){
                params.put("creator",user.getUserId());
            }
            if(docStatus.size()>0){
                params.put("docStatus",docStatus);
            }
            params.put("value", fluzzyParam);
            params.put("beginIndex", beginIndex);
            params.put("limit", limit);
            stockReports = stockReportMapper.fetchStockReportFuzzyByPage(params);
            for (int i = 0; i < stockReports.size(); i++) {
                StockReport stockReport = stockReports.get(i);
                List<StockReportItem> stockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
                for (int j = 0; j < stockReportItems.size(); j++) {
                    StockReportItem stockReportItem = stockReportItems.get(j);
                    List<StockReportMaterialItem> stockReportMaterialItemList = stockReportMapper.fetchStockReportMaterialItem(stockReportItem.getDocEntry(), stockReportItem.getLineId());
                    stockReportItem.setStockReportMaterialItems(stockReportMaterialItemList);
                }
                stockReport.setStockReportItems(stockReportItems);
            }
            return stockReports;
        } catch (Exception e) {
            logger.info(StockTaskData.OPREATION_EXCEPTION, e);
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR, StockOpResultDescription.STOCK_DATABASE_ERROR);
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
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
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
    public void saveStockReport(String token,StockReport stockReport) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;
        try {
            User user = userMapper.getUserByToken(token);
            stockReport.setCreateUserSign(user.getUserId().toString());
            status = ptm.getTransaction(def);
            super.saveBO(stockReport);
            ptm.commit(status);
        }catch (BusinessException ex){
            ptm.rollback(status);
            logger.info(StockTaskData.OPREATION_EXCEPTION,ex);
            throw ex;
        }catch (BusinessObjectException ex){
            ptm.rollback(status);
            logger.info(StockTaskData.OPREATION_EXCEPTION,ex);
            throw ex;
        }catch (Exception e) {
            if(status != null){
                ptm.rollback(status);
            }
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }


    /**
     * 更新库存任务汇报
     * @param stockReport
     * @return
     */
    @Override
    public void updateStockReport(String token,StockReport stockReport) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;
        try {
            User user = userMapper.getUserByToken(token);
            stockReport.setUpdateUserSign(user.getUserId().toString());
            status = ptm.getTransaction(def);
            super.updateBO(stockReport);
            ptm.commit(status);
        } catch (BusinessException ex){
            ptm.rollback(status);
            logger.info(StockTaskData.OPREATION_EXCEPTION,ex);
            throw ex;
        }catch (BusinessObjectException ex){
            ptm.rollback(status);
            logger.info(StockTaskData.OPREATION_EXCEPTION,ex);
            throw ex;
        }catch (Exception e) {
            if(status != null){
                ptm.rollback(status);
            }
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
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
            StockReport stockReport = stockReportMapper.fetchStockReportByEntry(docEntry);
            stockReport.setIsDeleted("Y");
            super.deleteBO(stockReport);
            ptm.commit(status);
        }catch (BusinessException e){
            ptm.rollback(status);
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            throw e;
        }catch (BusinessObjectException e){
            ptm.rollback(status);
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            throw e;
        }catch (Exception e){
            if(status != null){
                ptm.rollback(status);
            }
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
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
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
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
            for (int j=0;j<stockReportItem.getStockReportMaterialItems().size();j++){
                StockReportMaterialItem stockReportMaterialItem = stockReportItem.getStockReportMaterialItems().get(j);
                stockReportMaterialItem.setDocEntry(docEntry);
                stockReportMaterialItem.setLineId(stockReportItem.getLineId());
                if(stockReportMaterialItem.getBarCode()==null||stockReportMaterialItem.getBarCode().isEmpty()){
                    throw new BusinessException(StockOpResultCode.CODEBAR_IS_NULL,StockOpResultDescription.CODEBAR_IS_NULL);
                }
                stockReportMapper.saveStockReportMaterialItem(stockReportMaterialItem);
            }
        }
    }

    @Override
    protected void update(StockReport stockReport) {
        if (stockReport.getDocumentStatus().equals(StockTaskData.CLOSE)) {
            throw new BusinessException(StockOpResultCode.B1DOCENTRY_IS_EXISTENT,StockOpResultDescription.B1DOCENTRY_IS_EXISTENT);
        }
        stockReportMapper.deleteStockReport(stockReport.getDocEntry());
        stockReportMapper.deleteStockReportItem(stockReport.getDocEntry());
        stockReportMapper.deleteStockReportMaterialItem(stockReport.getDocEntry());
        save(stockReport);

    }

    @Override
    protected void delete(StockReport stockReport) {
        if (stockReport.getDocumentStatus().equals(StockTaskData.CLOSE)) {
            throw new BusinessException(StockOpResultCode.B1DOCENTRY_IS_EXISTENT,StockOpResultDescription.B1DOCENTRY_IS_EXISTENT);
        }
        stockReportMapper.updateIsDelete(stockReport.getDocEntry());
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