package org.edi.stocktask.repository;

import org.apache.log4j.Logger;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.mapper.CodeBarMapper;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
@Component(value="boRepositoryCodeBar")
public class BORepositoryCodeBar implements IBORepositoryCodeBar{
    private static Logger log = Logger.getLogger(BORepositoryCodeBar.class);
    private final static String OK = "0";
    private final static String CODE = "RETURNCODE";
    private final static String MESSAGE = "MESSAGE";



    @Autowired
    private CodeBarMapper codeBarMapper;

    @Autowired
    private StockTaskMapper stockTaskMapper;

    /**
     * 条码解析
     * @param codebar
     * @return
     */
    @Override
    public List<ICodeBar> parseCodeBar(String codebar,String baseType,int baseEntry,int baseLine) {
        if(codebar==null||codebar.isEmpty()){
            throw new BusinessException(StockOpResultCode.CODEBAR_IS_NULL,StockOpResultDescription.CODEBAR_IS_NULL);
        }
        if(baseType==null||baseType.isEmpty()){
            throw new BusinessException(StockOpResultCode.STOCK_BASETYPE_IS_NULL, StockOpResultDescription.STOCK_BASETYPE_IS_NULL);
        }
        if(baseEntry==0){
            throw new BusinessException(StockOpResultCode.STOCK_BASEENTRY_IS_NULL,StockOpResultDescription.STOCK_BASEENTRY_IS_NULL);
        }
        List<ICodeBar> listCodeBar = null;
        HashMap<String,Object> codeBarParam = new HashMap();
        codeBarParam.put("codebar",codebar);
        codeBarParam.put("baseType",baseType);
        codeBarParam.put("baseEntry",baseEntry);
        codeBarParam.put("baseLine",baseLine);
        try {
            listCodeBar = codeBarMapper.parseCodeBar(codeBarParam);
            for (ICodeBar item:listCodeBar) {
                if(CODE.equals(item.getProName().toUpperCase())){
                    if(!item.getProValue().equals(OK)){
                        throw new BusinessException(item.getProValue(),item.getProDesc());
                    }else {
                        return listCodeBar;
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            log.warn(e);
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,String.format(StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL,codebar));
        }

        return listCodeBar;
    }

    /**
     * 批量解析条码
     * @param codeBars 条码集合
     * @return
     */
    @Override
    public List<StockReportItem> parseBatchCodeBar(List<String> codeBars) {
        try{
            HashMap<String,Object> codeBarParam;
            List<StockReportItem> stockReportItems = new ArrayList<>();
            List<ICodeBar> listCodeBar = null;
            List<List<ICodeBar>> listCodeBars = new ArrayList<>();
            //解析条码集合
            for (String codeBar:codeBars) {
                codeBarParam = new HashMap();
                codeBarParam.put("codebar",codeBar);
                codeBarParam.put("baseType","");
                codeBarParam.put("baseEntry","");
                codeBarParam.put("baseLine","");
                listCodeBar = codeBarMapper.parseCodeBar(codeBarParam);
                if(listCodeBar == null || listCodeBar.size() ==0){
                    throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,String.format(StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL,codeBar));
                }
                listCodeBars.add(listCodeBar);
            }


            //获取解析后的单据类型、单据号
            List<ICodeBar> defaultCodeBars = listCodeBars.get(0);
            HashMap<String,String> docInfo = this.getTaskInfo(defaultCodeBars);

            //查找对应的任务行集合
            List<IStockTaskItem>  stockTasks = stockTaskMapper.fetchSyncStockTaskItem(Integer.valueOf(docInfo.get(StockTaskData.DOCENTRY)),
                    docInfo.get(StockTaskData.DOCTYPE));

            // 对解析对条码和任务行进行匹配   根据任务行获取汇报行  调用汇报行的静态方法
            if(stockTasks == null || stockTasks.size() == 0){
                throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL);
            }
            return stockReportItems;
        }catch (Exception e){
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL);
        }
    }


    private HashMap<String,String> getTaskInfo(List<ICodeBar> codeBars){
        HashMap<String,String> docInfo = new HashMap<>();
        for (ICodeBar codeBar:codeBars) {
            if(StockTaskData.DOCTYPE.equals(codeBar.getProName().toUpperCase())){
                docInfo.put(StockTaskData.DOCTYPE,codeBar.getProValue());
            }
            if (StockTaskData.DOCENTRY.equals(codeBar.getProName().toUpperCase())){
                docInfo.put(StockTaskData.DOCENTRY,codeBar.getProValue());
            }
        }
        return docInfo;
    }

}
