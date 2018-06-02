package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IStockTaskService {

    IResult<StockTask> fetchStockTask(String token);
    IResult<IStockTask> fetchStockTask(Integer objectKey,String token);
    IResult<?> saveStockTask(List<IStockTask> stockTasks,String token);

}
