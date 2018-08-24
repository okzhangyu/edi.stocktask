package org.edi.stocktask.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.UserMapper;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
@Component(value="boRepositoryStockTask")
public class BORepositoryStockTask implements  IBORepositoryStockTask {

    Logger logger = LoggerFactory.getLogger(BORepositoryStockTask.class);
    @Autowired
    private StockTaskMapper stockTaskMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<IStockTask> fetchStockTask(String token, String fluzzyParam, int beginIndex, int limit, List<String> docStatus) {
        List<IStockTask> stockTasks;
        try {
            User user = userMapper.getUserByToken(token);
            HashMap<String, Object> params = new HashMap<>();
            if(!user.getIsSupperUser().toUpperCase().equals(StockTaskData.YES)){
                params.put("reporterId",user.getUserId());
            }
            if(docStatus.size()>0){
                params.put("docStatus",docStatus);
            }
            params.put("value", fluzzyParam);
            params.put("beginIndex", beginIndex);
            params.put("limit", limit);
            return fetchStockTask(params);
        } catch (Exception e) {
            logger.info(StockTaskData.OPREATION_EXCEPTION, e);
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR, StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }

    /**
     * 查询库存任务
     * @return
     */
    public List<IStockTask> fetchStockTask(HashMap<String,Object> paramMap) {
        List<IStockTask> stockTasks;
        stockTasks = stockTaskMapper.fetchStockTaskFuzzyByPage(paramMap);
        if (stockTasks.size() == 0) {
            return stockTasks;
        }
        for (int i = 0; i < stockTasks.size(); i++) {
            List<IStockTaskItem> stockTaskItems = stockTaskMapper.fetchStockTaskItem(stockTasks.get(i).getObjectKey(), stockTasks.get(i).getDocumentType());
            if (stockTaskItems != null) {
                stockTasks.get(i).setStockTaskItems(stockTaskItems);
                stockTasks.get(i).initDocStatus();
            }
        }
        return stockTasks;

    }




    @Override
    public List<IStockTask> fetchStockTaskByCondition(int docEntry, String docType) {
        if(docEntry==0){
            throw new BusinessException(ResultDescription.DOCENTRY_IS_NULL);
        }
        HashMap<String,Object> stockTaskCondition = new HashMap<>();
        stockTaskCondition.put("docEntry",docEntry);
        stockTaskCondition.put("docType",docType);
        try{
            List<IStockTask>  stockTasks = stockTaskMapper.fetchStockTaskByCondition(stockTaskCondition);
            if(stockTasks.size() == 0) {
                return stockTasks;
            }
            for (int i = 0;i<stockTasks.size();i++){
                List<IStockTaskItem> stockTaskItems = stockTaskMapper.fetchSyncStockTaskItem(stockTasks.get(i).getObjectKey(),stockTasks.get(i).getDocumentType());
                if(stockTaskItems!=null){
                    stockTasks.get(i).setStockTaskItems(stockTaskItems);
                    stockTasks.get(i).initDocStatus();
                }
            }
            return stockTasks;
        }catch (Exception e){
            logger.info(StockTaskData.OPREATION_EXCEPTION, e);
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
    }

    @Override
    public List<IMaterial> fetchStockTaskMaterials(Integer docEntry){
        if(docEntry == 0){
            throw new BusinessException(StockOpResultDescription.DOCENTRY_IS_EMPTY);
        }
        try{
            List<IMaterial> materials = stockTaskMapper.fetchStockTaskMaterial(docEntry);
            return materials;
        }catch (Exception e){
            logger.info(StockTaskData.OPREATION_EXCEPTION, e);
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }

    }



}