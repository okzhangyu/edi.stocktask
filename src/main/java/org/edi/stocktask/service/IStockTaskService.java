package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockTaskService {

    /**
     * 查询库存任务
     * @param token
     * @return
     */
    Result<StockTask> fetchStockTask(String token,String param);

    /**
     * 条件查询库存任务
     * @param token
     * @param docEntry
     * @param docType
     * @return
     */
    Result<StockTask> fetchStockTaskByCondition(String token,String docEntry,String docType);

    /**
     * 保存库存任务
     * @param stockTasks
     * @param token
     * @return
     */
    IResult<?> saveStockTask(List<IStockTask> stockTasks, String token);


}
