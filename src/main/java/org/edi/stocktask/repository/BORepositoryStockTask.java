package org.edi.stocktask.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
@Transactional
@Component(value="boRepositoryStockTask")
public class BORepositoryStockTask implements  IBORepositoryStockTask {


    @Autowired
    private StockTaskMapper stockTaskMapper;

    /**
     * 分页查询库存任务
     * @return
     */
    public List<IStockTask> fetchStockTask(String param,int beginIndex,int limit){
        List<IStockTask> stockTasks;
        try{
            if(param!=null && !param.isEmpty()){
                HashMap<String,Object> params = new HashMap<>();
                params.put("value",param);
                params.put("beginIndex",beginIndex);
                params.put("limit",limit);
                stockTasks = stockTaskMapper.fetchStockTaskFuzzyByPage(params);
            }else {
                stockTasks = stockTaskMapper.fetchStockTaskByPage(beginIndex,limit);
            }
            if(stockTasks.size() == 0) {
                return stockTasks;
            }
            for (int i = 0;i<stockTasks.size();i++){
                List<IStockTaskItem> stockTaskItems = stockTaskMapper.fetchStockTaskItem(stockTasks.get(i).getObjectKey(),stockTasks.get(i).getDocumentType());
                if(stockTaskItems!=null){
                    stockTasks.get(i).setStockTaskItems(stockTaskItems);
                    stockTasks.get(i).initDocStatus();
                }
            }
            return stockTasks;
        }catch (Exception e){
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }
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
            throw new DBException(StockOpResultCode.STOCK_DATABASE_ERROR,StockOpResultDescription.STOCK_DATABASE_ERROR);
        }

    }



}