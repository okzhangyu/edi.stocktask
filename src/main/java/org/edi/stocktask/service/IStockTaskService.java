package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.material.Material;
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
    Result<IStockTask> fetchStockTask(String token,String param);

    /**
     * 条件查询库存任务
     * @param token
     * @param docEntry
     * @param docType
     * @return
     */
    Result<IStockTask> fetchStockTaskByCondition(String token,int docEntry,String docType);


    /**
     * 查询任务单据的物料信息
     *
     * @pram docEntry
     * @return
     */
    Result<IMaterial> fetchStockTaskMaterial(String token, Integer docEntry);
}
