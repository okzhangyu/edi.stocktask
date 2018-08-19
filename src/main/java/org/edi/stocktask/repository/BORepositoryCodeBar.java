package org.edi.stocktask.repository;

import org.apache.log4j.Logger;
import org.edi.freamwork.exception.BusinessException;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.dto.CodeBarParam;
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
    private final static String OK = "0";
    private final static String CODE = "RETURNCODE";


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
            for (int index = 0;index<listCodeBar.size();index++) {
                if(CODE.equals(listCodeBar.get(index).getProName().toUpperCase())){
                    if(!listCodeBar.get(index).getProValue().equals(OK)){
                        throw new BusinessException(listCodeBar.get(index).getProValue(),listCodeBar.get(index).getProDesc());
                    }else {
                        listCodeBar.remove(index);
                        return listCodeBar;
                    }
                }
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
     * @param codeBarParam 条码集合
     * @return
     */
    @Override
    public List<List<?>> parseBatchCodeBar(CodeBarParam codeBarParam) {
        HashMap<String,Object> codeBarParams = new HashMap();
        codeBarParams.put("baseType",codeBarParam.getBaseType());
        codeBarParams.put("baseEntry",codeBarParam.getBaseEntry());
        codeBarParams.put("codeBars","013|3977|1|22|4");
        List<List<?>> listCodeBars = null;
        try{
            listCodeBars = codeBarMapper.parseBatchCodeBar(codeBarParams);
        }catch (Exception e){
            throw new BusinessException(StockOpResultCode.BARCODE_ANALYSIS_IS_FAIL,StockOpResultDescription.BARCODE_ANALYSIS_IS_FAIL);
        }
        return listCodeBars;
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
