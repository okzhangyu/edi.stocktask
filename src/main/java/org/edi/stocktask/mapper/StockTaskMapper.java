package org.edi.stocktask.mapper;

import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;

import java.util.HashMap;
import java.util.List;

public interface StockTaskMapper {

    List<StockTask> fetchStockTask();
    List<StockTaskItem> fetchStockTaskItem(Integer objectKey);
    List<StockTaskItem> fetchAllStockTaskItem();
    List<StockTask> fetchStockTaskFuzzy(String value);
    List<StockTask> fetchStockTaskByCondition(HashMap<String,Object> stockTaskCondition);
}
