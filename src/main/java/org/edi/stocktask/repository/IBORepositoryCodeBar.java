package org.edi.stocktask.repository;

import org.edi.stocktask.bo.codeBar.ICodeBar;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
public interface IBORepositoryCodeBar {

    /**
     * 解析条码
     * @param codebar 条码值
     * @param baseType 条码值
     * @param baseEntry 条码值
     * @param baseLine 条码值
     * @return 获取解析结果
     */
    public List<ICodeBar> parseCodeBar(String codebar,String baseType,int baseEntry,int baseLine);
}
