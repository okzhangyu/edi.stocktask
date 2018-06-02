package org.edi.stocktask.repository;

import org.edi.stocktask.bo.stocktask.StockTask;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBORepositoryStockTask {
 List<StockTask> fetchStockTask();
}
