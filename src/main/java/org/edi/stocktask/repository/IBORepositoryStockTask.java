package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBORepositoryStockTask {

    /**
     * 查询库存任务
     * @return
     */
    List<StockTask> fetchStockTask(String param);


    List<StockTaskItem> fetchAllStockTaskItem();


}
