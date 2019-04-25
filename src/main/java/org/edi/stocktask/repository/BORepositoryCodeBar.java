package org.edi.stocktask.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.bo.stocktask.IStockTaskItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.dto.CodeBarParam;
import org.edi.stocktask.dto.CodeBarParseParam;
import org.edi.stocktask.dto.CodeBarParseResult;
import org.edi.stocktask.dto.ItemCodeQuantity;
import org.edi.stocktask.mapper.CodeBarMapper;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author Fancy
 * @date 2018/7/10
 */
@Component(value="boRepositoryCodeBar")
public class BORepositoryCodeBar implements IBORepositoryCodeBar{
    Logger logger = LoggerFactory.getLogger(BORepositoryCodeBar.class);

    @Autowired
    private CodeBarMapper codeBarMapper;

    @Autowired
    private StockTaskMapper stockTaskMapper;


    @Autowired
    private PlatformTransactionManager ptm;


    /**
     * 条码解析
     * @param codebar
     * @return
     */
    @Override
    public List<ICodeBar> parseCodeBar(String codebar,String baseType,int baseEntry,int baseLine,String itemCode) {
        List<ICodeBar> listCodeBar = null;
        HashMap<String,Object> codeBarParam = new HashMap();
        codeBarParam.put("codebar",codebar);
        codeBarParam.put("baseType",baseType);
        codeBarParam.put("baseEntry",baseEntry);
        codeBarParam.put("baseLine",baseLine);
        codeBarParam.put("itemCode",itemCode);
        try {
            listCodeBar = codeBarMapper.parseCodeBar(codeBarParam);
            if((int)codeBarParam.get("code")!=0){
                throw new BusinessException(codeBarParam.get("code").toString(),codeBarParam.get("message").toString());
            }
        }catch (BusinessException e){
            logger.error(StockTaskData.OPREATION_EXCEPTION,e);
            throw e;
        } catch (Exception e){
            logger.error(StockTaskData.OPREATION_EXCEPTION,e);
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,String.format(StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL,codebar));
        }
        return listCodeBar;
    }

    /**
     * 加强条码解析
     * @param codebar
     * @return
     */
    @Override
    public List<ICodeBar> strengthenParseCodeBar(String codebar, String baseType, int baseEntry, int baseLine, String itemCode, List<ItemCodeQuantity> itemCodeQuantity) {
        List<ICodeBar> listCodeBar = null;
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status =null;
        String id = UUID.randomUUID().toString();
        try {
            status = ptm.getTransaction(def);
            if(itemCodeQuantity != null) {
                for (int i = 0; i < itemCodeQuantity.size(); i++) {
                    itemCodeQuantity.get(i).setId(id);
                    codeBarMapper.addCodeBarParseParam(itemCodeQuantity.get(i));
                }
            }
            HashMap<String,Object> codeBarParam = new HashMap();
            codeBarParam.put("codebar",codebar);
            codeBarParam.put("baseType",baseType);
            codeBarParam.put("baseEntry",baseEntry);
            codeBarParam.put("baseLine",baseLine);
            codeBarParam.put("itemCode",itemCode);
            codeBarParam.put("id",id);
            listCodeBar = codeBarMapper.strengthenParseCodeBar(codeBarParam);
            if((int)codeBarParam.get("code")!=0){
                throw new BusinessException(codeBarParam.get("code").toString(),codeBarParam.get("message").toString());
            }
            ptm.commit(status);
            logger.info("条码解析结果" + listCodeBar.toString());
        }catch (BusinessException e){
            logger.error(StockTaskData.OPREATION_EXCEPTION,e);
            ptm.rollback(status);
            throw e;
        } catch (Exception e){
            logger.error(StockTaskData.OPREATION_EXCEPTION,e);
            if(status != null){
                ptm.rollback(status);
            }
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,String.format(StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL,codebar));
        }
        return listCodeBar;
    }


    /**
     * 批量解析条码
     * @param codeBarParams 条码集合
     * @return
     */
    @Override
    public List<StockReportItem> parseBatchCodeBar(CodeBarParam codeBarParams) {
        String id = UUID.randomUUID().toString();
        List<CodeBarParseResult> listCodeBars = null;

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status =null;
        try {
            status = ptm.getTransaction(def);

            List<CodeBarParseParam> codeBarParseParams = CodeBarParseParam.createParseParam(id, codeBarParams);
            for (CodeBarParseParam param : codeBarParseParams) {
                codeBarMapper.addCodeBarBatchParseParam(param);
            }
            logger.info("param"+codeBarParseParams.toString());
            HashMap<String, Object> codeBarParamsList = new HashMap<>();
            codeBarParamsList.put("baseType", codeBarParams.getBaseType());
            codeBarParamsList.put("id", id);
            codeBarParamsList.put("baseEntry", codeBarParams.getBaseEntry());
            logger.info("批量条码解析param:" + "id=" + id + ";" + codeBarParams.toString());
            listCodeBars = codeBarMapper.parseBatchCodeBar(codeBarParamsList);
            if ((int) codeBarParamsList.get("code") != 0) {
                throw new BusinessException(codeBarParamsList.get("code").toString(), codeBarParamsList.get("message").toString());
            }
            logger.info("批量条码解析结果" + listCodeBars.toString());
            List<IStockTaskItem> stockTaskItems = stockTaskMapper.fetchNoDealStockTaskItem(codeBarParams.getBaseEntry(), codeBarParams.getBaseType());
            List<StockReportItem> stockReportItems = StockReportItem.createStockReportItemList(stockTaskItems, listCodeBars);
            ptm.commit(status);
            return stockReportItems;
        } catch (BusinessException e) {
            logger.error(StockTaskData.OPREATION_EXCEPTION, e);
            ptm.rollback(status);
            throw e;
        } catch (Exception e) {
            logger.error(StockTaskData.OPREATION_EXCEPTION, e);
            if(status != null) {
                ptm.rollback(status);
            }
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,StockOpResultDescription.BARCODE_ANALYSIS_EXCEPTION);
        }
    }


}
