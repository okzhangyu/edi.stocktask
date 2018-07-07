package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
     * 查询库存任务
     * @return
     */
    @Override
    public List<StockTask> fetchStockTask(){
        List<StockTask> stockTasks = stockTaskMapper.fetchStockTask();
        for (int i = 0;i<stockTasks.size();i++){
            List<StockTaskItem> stockTaskItems = stockTaskMapper.fetchStockTaskItem(stockTasks.get(i).getObjectKey());
            if(stockTaskItems!=null){
                stockTasks.get(i).setStockTaskItems(stockTaskItems);
            }
        }
        return stockTasks;
    }

    /**
     * 根据OBJECTKEY查询库存任务明细
     * @param objectKey
     * @return
     */
    public List<StockTaskItem> fetchStockTaskItem(Integer objectKey){
        List<StockTaskItem> stockTaskItems = stockTaskMapper.fetchStockTaskItem(objectKey);
        return stockTaskItems;
    }

    /**
     * 查询所有库存任务明细
     * @return
     */
    public List<StockTaskItem> fetchAllStockTaskItem(){
        List<StockTaskItem> stockTaskItems = stockTaskMapper.fetchAllStockTaskItem();
        return stockTaskItems;
    }
}