package org.edi.stocktask.service;

import org.edi.freamwork.data.Result;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.dto.CodeBarParam;
import org.edi.stocktask.dto.ItemCodeQuantity;

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
   /* Result<ICodeBar> parseCodeBar(String token, String codeBar , String baseType, int baseEntry, int baseLine, String itemCode);
   */

    /**
     * 加强解析条码
     * @param codeBar
     * @return
     */
     Result<ICodeBar> strengthenParseCodeBar(String token, String codeBar, String baseType, int baseEntry, int baseLine, String itemCode,CodeBarParam codeBarParam);


    /**
     * 批量解析codebar
     * @param token
     * @param codeBarParam 条码集合
     * @return
     */
    Result<StockReportItem> parseBatchCodeBar(String token, CodeBarParam codeBarParam);

}
