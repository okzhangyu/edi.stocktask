package org.edi.stocktask.service;

import org.edi.freamwork.data.Result;
import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;

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

    Result<IStockTask> fetchStockTask(String token,String param,int beginIndex,int limit);


    /**
     * 条件查询库存任务
     * @param token
     * @param docEntry
     * @param docType
     * @return
     */
    Result<IStockTask> fetchStockTaskByCondition(String token, int docEntry, String docType);


    /**
     * 查询任务单据的物料信息
     *
     * @pram docEntry
     * @return
     */
    Result<IMaterial> fetchStockTaskMaterial(String token, Integer docEntry);
}
