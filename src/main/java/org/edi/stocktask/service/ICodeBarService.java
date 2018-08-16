package org.edi.stocktask.service;

import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.codeBar.ICodeBar;

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
}
