package org.edi.stocktask.mapper;

import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.material.Material;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;

import java.util.HashMap;
import java.util.List;

public interface StockTaskMapper {

    List<IStockTask> fetchStockTask();
    List<IStockTaskItem> fetchStockTaskItem(Integer objectKey);
    List<IStockTaskItem> fetchAllStockTaskItem();
    List<IStockTask> fetchStockTaskFuzzy(String value);
    List<IStockTask> fetchStockTaskByCondition(HashMap<String,Object> stockTaskCondition);

    /**
     * 获取库存任务单的物料信息
     * @return
     */
    List<IMaterial> fetchStockTaskMaterial(Integer docEntry);
}
