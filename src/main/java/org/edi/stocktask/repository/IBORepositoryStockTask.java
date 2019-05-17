package org.edi.stocktask.repository;

import org.edi.stocktask.bo.material.IMaterial;
import org.edi.stocktask.bo.stocktask.IStockTask;

import java.util.HashMap;
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

    List<IStockTask> fetchStockTask(HashMap<String,Object> paramMap);

    List<IStockTask> fetchStockTask(String token,String param,int beginIndex,int limit,List<String> docStatus,List<String> transType);

    List<IStockTask> fetchStockTaskByCondition(int docEntry, String docType);

    List<IMaterial> fetchStockTaskMaterials(Integer docEntry);
}
