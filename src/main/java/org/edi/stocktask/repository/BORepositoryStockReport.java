package org.edi.stocktask.repository;

import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.freamwork.repository.BORepository;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.mapper.StockReportMapper;
import org.edi.stocktask.util.B1DocEntryVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;
import java.text.ParseException;
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


    /**
     * 查询任务汇报清单
     * @return
     */
    @Override
    public List<StockReport> fetchStockReport(String param){
        List<StockReport> stockReports;
        if(param!=null && !param.isEmpty()){
            stockReports = stockReportMapper.fetchStockReportFuzzy(param);
        }else {
            stockReports = stockReportMapper.fetchStockReport();
        }
        if(stockReports.size() == 0) {
            return stockReports;
        }
        for(int i=0;i<stockReports.size();i++){
            StockReport stockReport = stockReports.get(i);
            List<StockReportItem> stockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(stockReportItems);
        }
        return stockReports;
    }


    /**
     * 查询任务汇报清单
     * @return
     */

    public List<StockReport> fetchStockReportByPage (String param,int beginIndex,int limit){
        List<StockReport> stockReports;
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
            stockReport.setStockReportItems(stockReportItems);
        }
        return stockReports;
    }




    /**
     * 根据DOCENTRY查询库存任务汇报
     * @param docEntry
     * @return
     */
    @Override
    public StockReport fetchStockReportByEntry(Integer docEntry){
        StockReport stockReport = stockReportMapper.fetchStockReportByEntry(docEntry);
        List<StockReportItem> stockReportItems = stockReportMapper.fetchStockReportItem(docEntry);
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
        stockReports = stockReportMapper.fetchUnSyncStockReport();
        if(stockReports != null && stockReports.size() > 0){
            for(int i=0;i<stockReports.size();i++){
                IStockReport stockReport = stockReports.get(i);
                stockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
                stockReport.setStockReportItems(stockReportItems);
            }
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
        TransactionStatus status = ptm.getTransaction(def);
        try {
            super.saveBO(stockReport);
            ptm.commit(status);
        }catch (BusinessObjectException ex){
            throw ex;
        }catch (Exception e) {
            ptm.rollback(status);
            throw new DBException(StockOpResultCode.STOCK_OBJECT_DATABASE_ERROR,e.getMessage());
        }
    }



    /**
     * 更新保存库存任务汇报
     * @param stockReport
     * @return
     */
    public void updateSingleStockReport(StockReport stockReport) throws ParseException{
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        DateFormat df=DateFormat.getDateTimeInstance();
        String nowDate=df.format(new Date());
        TransactionStatus status = ptm.getTransaction(def);
        try {
                int docEntry = stockReport.getDocEntry();
                stockReport.setDocEntry(docEntry);
                stockReport.setUpdateDate(nowDate);
                stockReportMapper.saveStockReport(stockReport);
                for (int j = 0; j < stockReport.getStockReportItems().size(); j++) {
                    StockReportItem stockReportItem = stockReport.getStockReportItems().get(j);
                    stockReportItem.setDocEntry(docEntry);
                    stockReportItem.setLineId(j + 1);
                    stockReportMapper.saveStockReportItem(stockReportItem);
                }

            ptm.commit(status);
        }catch(Exception e){
            e.printStackTrace();
            ptm.rollback(status);
            throw e;
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
        TransactionStatus status = ptm.getTransaction(def);
        try {
            super.updateBO(stockReport);
            ptm.commit(status);
        } catch (BusinessObjectException ex){
            throw ex;
        }catch (Exception e) {
            ptm.rollback(status);
            throw new DBException(StockOpResultCode.STOCK_OBJECT_DATABASE_ERROR,e.getMessage());
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
        TransactionStatus status = ptm.getTransaction(def);
        if(!b1DocEntryVerification.B1EntryCheck(docEntry)){
            throw new BusinessException(ResultDescription.B1DOCENTRY_IS_EXISTENT);
        }
        try {
            stockReportMapper.deleteStockReport(docEntry);
            stockReportMapper.deleteStockReportItem(docEntry);
            ptm.commit(status);
        }catch(Exception e){
            e.printStackTrace();
            ptm.rollback(status);
            throw e;
        }
    }

    /**
     * 条件查询任务汇报
     * @param companyName
     * @param baseDocumentType
     * @param baseDocumentEntry
     * @return
     */
    @Override
    public List<StockReport> fetchStockReportByCondition(String companyName, String baseDocumentType, String baseDocumentEntry) {
        HashMap<String,String> stockReportCondition = new HashMap<>();
        stockReportCondition.put("companyName",companyName);
        stockReportCondition.put("baseDocumentType",baseDocumentType);
        stockReportCondition.put("baseDocumentEntry",baseDocumentEntry);
        List<StockReport> StockReports = stockReportMapper.fetchStockReportByCondition(stockReportCondition);
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        return StockReports;
    }


    /**
     * 模糊查询库存任务汇报
     * @param value
     * @return
     */
    @Override
    public List<StockReport> fetchStockReportFuzzy(String value){
        List<StockReport> StockReports = stockReportMapper.fetchStockReportFuzzy(value);
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = stockReportMapper.fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        return StockReports;
    }


    @Override
    protected void save(StockReport stockReport) {
        int docEntry = stockReportMapper.fetchSequenceOfDocEntry();
        stockReport.setDocEntry(docEntry);
        DateFormat df = DateFormat.getDateTimeInstance();
        String nowDate = df.format(new Date());
        stockReport.setCreateDate(nowDate);
        stockReportMapper.saveStockReport(stockReport);
        for (int j = 0; j < stockReport.getStockReportItems().size(); j++) {
            StockReportItem stockReportItem = stockReport.getStockReportItems().get(j);
            stockReportItem.setDocEntry(docEntry);
            stockReportItem.setLineId(j + 1);
            stockReportMapper.saveStockReportItem(stockReportItem);
        }
    }

    @Override
    protected void update(StockReport stockReport) {
        if (!b1DocEntryVerification.B1EntryCheck(stockReport.getDocEntry())) {
            throw new BusinessException(ResultDescription.B1DOCENTRY_IS_EXISTENT);
        }
        stockReportMapper.updateStockReport(stockReport);
        for (int j = 0; j < stockReport.getStockReportItems().size(); j++) {
            StockReportItem stockReportItem = stockReport.getStockReportItems().get(j);
            stockReportMapper.updateStockReportItem(stockReportItem);
        }
    }


    @Override
    protected void delete(StockReport bo) {
    }
}