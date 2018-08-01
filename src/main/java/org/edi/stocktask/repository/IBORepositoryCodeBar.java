package org.edi.stocktask.repository;

import org.edi.stocktask.bo.codeBar.CodeBar;
import org.edi.stocktask.bo.codeBar.ICodeBar;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
public interface IBORepositoryCodeBar {

    /**
     * 解析条码
     * @param codeBar 条码值
     * @return 获取解析结果
     */
    List<ICodeBar> parseCodeBar(String codeBar);
}
