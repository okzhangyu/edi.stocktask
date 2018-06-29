package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */

@Transactional
@Component("BORepositoryStockTask")
public class BORepositoryStockTask implements  IBORepositoryStockTask {


    @Autowired
    private IBORepositoryStockTask iBORepositoryStockTask;

    //查询完整库存任务
    public List<StockTask> fetchStockTask(){
        List<StockTask> stockTasks = iBORepositoryStockTask.fetchStockTask();
        for (int i = 0;i<stockTasks.size();i++){
            List<StockTaskItem> stockTaskItems = iBORepositoryStockTask.fetchStockTaskItem(stockTasks.get(i).getObjectKey());
            if(stockTaskItems!=null){
                stockTasks.get(i).setStockTaskItems(stockTaskItems);
            }
        }
        return stockTasks;
    }

    //根据OBJECTKEY查询库存任务明细
    public List<StockTaskItem> fetchStockTaskItem(Integer objectKey){
        List<StockTaskItem> stockTaskItems = iBORepositoryStockTask.fetchStockTaskItem(objectKey);
        return stockTaskItems;
    }

    //查询所有库存任务明细
    public List<StockTaskItem> fetchAllStockTaskItem(){
        List<StockTaskItem> stockTaskItems = iBORepositoryStockTask.fetchAllStockTaskItem();
        return stockTaskItems;
    }
}
