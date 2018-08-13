package org.edi.stocktask.mapper;

import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;

import java.util.HashMap;
import java.util.List;

public interface StockTaskMapper {

    List<IStockTask> fetchStockTask();
    List<IStockTask> fetchStockTaskByPage(int beginIndex,int limit);
    List<IStockTaskItem> fetchStockTaskItem(Integer objectKey,String docType);
    List<IStockTaskItem> fetchAllStockTaskItem();
    List<IStockTask> fetchStockTaskFuzzy(String value);
    List<IStockTask> fetchStockTaskFuzzyByPage(HashMap<String,Object> params);
    List<IStockTask> fetchStockTaskByCondition(HashMap<String,Object> stockTaskCondition);

    /**
     * 获取库存任务单的物料信息
     * @return
     */
    List<IMaterial> fetchStockTaskMaterial(Integer docEntry);

    /**
     * 查询已汇报的任务行
     * @param docEntry 单据号
     * @param docType 单据类型
     * @return
     */
    List<IStockTaskItem> fetchSyncStockTaskItem(Integer docEntry,String docType);
}
