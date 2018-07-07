package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;

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
    Result<StockTask> fetchStockTask(String token);

    /**
     * 保存库存任务
     * @param stockTasks
     * @param token
     * @return
     */
    IResult<?> saveStockTask(List<IStockTask> stockTasks, String token);


}
