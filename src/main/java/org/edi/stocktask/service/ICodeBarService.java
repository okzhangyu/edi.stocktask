package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
public interface ICodeBarService {
    /**
     * 解析条码
     * @param codeBar
     * @return
     */
    Result<ICodeBar> parseCodeBar(String token, String codeBar ,String baseType, int baseEntry, int baseLine);


    /**
     * 批量解析codebar
     * @param token
     * @param codeBars 条码集合
     * @return
     */
    Result<StockReportItem> parseBatchCodeBar(String token, List<String> codeBars);
}
