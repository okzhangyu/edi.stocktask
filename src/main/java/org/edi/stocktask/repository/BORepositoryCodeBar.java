package org.edi.stocktask.repository;

import org.apache.log4j.Logger;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.dto.*;
import org.edi.stocktask.mapper.CodeBarMapper;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
@Component(value="boRepositoryCodeBar")
public class BORepositoryCodeBar implements IBORepositoryCodeBar{
    private static Logger log = Logger.getLogger(BORepositoryCodeBar.class);

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
            e.printStackTrace();
            throw e;
        } catch (Exception e){
            e.printStackTrace();
            log.warn(e);
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
    public List<CodeBarResult> parseBatchCodeBar(List<CodeBarParam>  codeBarParams,String baseType,Integer baseEntry) {
        List<CodeBarParseParam> codeBarParseParams = CodeBarParseParam.createParseParam(codeBarParams);
        HashMap<String,Object> codeBarParamsList = new HashMap<>();
        codeBarParamsList.put("codeBarParams",codeBarParseParams);
        codeBarParamsList.put("baseType",baseType);
        codeBarParamsList.put("baseEntry",baseEntry);
        List<CodeBarParseResult> listCodeBars = null;
        try{
            listCodeBars = codeBarMapper.parseBatchCodeBar(codeBarParamsList);
            if((int)codeBarParamsList.get("code")!=0){
                throw new BusinessException(codeBarParamsList.get("code").toString(),codeBarParamsList.get("message").toString());
            }
        }catch (BusinessException e){
            e.printStackTrace();
            throw e;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL);
        }
        return CodeBarResult.createCodeBarResult(listCodeBars);
    }



}
