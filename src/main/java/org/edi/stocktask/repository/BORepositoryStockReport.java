package org.edi.stocktask.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.util.CharsetConvert;
import org.edi.stocktask.bo.stockreport.IStockReport;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
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
public class BORepositoryStockReport implements IBORepositoryStockReport{

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
     * @param stockReports
     * @return
     */
    public void saveStockReports(List<StockReport> stockReports) throws ParseException{
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        StockReport stockReport;
        DateFormat df=DateFormat.getDateTimeInstance();
        String nowDate=df.format(new Date());
        TransactionStatus status = ptm.getTransaction(def);
        try {
            for (int i = 0; i < stockReports.size(); i++) {
                stockReport = stockReports.get(i);
                //if(stockReport)
                int docEntry = stockReportMapper.fetchSequenceOfDocEntry();
                stockReport.setDocEntry(docEntry);
                stockReport.setCreateDate(nowDate);
                stockReportMapper.saveStockReport(stockReport);
                for (int j = 0; j < stockReports.get(i).getStockReportItems().size(); j++) {
                    StockReportItem stockReportItem = stockReports.get(i).getStockReportItems().get(j);
                    stockReportItem.setDocEntry(docEntry);
                    stockReportItem.setLineId(j + 1);
                    stockReportMapper.saveStockReportItem(stockReportItem);
                }
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
     * @param stockReports
     * @return
     */
    @Override
    public void updateStockReport(List<StockReport> stockReports) {
        //TODO 更新库存任务汇报
        //1、先查询库存任务汇报是否生成单据  （条件：B1DocEntry的值为null或者0）
        //2、如果任务汇报没有生成单据，先删除再保存
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = ptm.getTransaction(def);
        for (int i=0;i<stockReports.size();i++) {
            StockReport stockReport = stockReports.get(i);
            if (!b1DocEntryVerification.B1EntryCheck(stockReport.getDocEntry())) {
                throw new BusinessException(CharsetConvert.convert(ResultDescription.B1DOCENTRY_IS_EXISTENT));
            }
            try {
                stockReportMapper.updateStockReport(stockReport);
                for (int j = 0; j < stockReport.getStockReportItems().size(); j++) {
                    StockReportItem stockReportItem = stockReport.getStockReportItems().get(j);
                    stockReportMapper.updateStockReportItem(stockReportItem);
                }
                ptm.commit(status);
            } catch (Exception e) {
                e.printStackTrace();
                ptm.rollback(status);
                throw e;
            }

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
            throw new BusinessException(CharsetConvert.convert(ResultDescription.B1DOCENTRY_IS_EXISTENT));
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





}