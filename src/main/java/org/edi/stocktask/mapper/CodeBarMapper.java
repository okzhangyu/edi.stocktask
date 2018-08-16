package org.edi.stocktask.mapper;

import org.edi.stocktask.bo.codeBar.ICodeBar;

import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/19
 */
public interface CodeBarMapper {

    /**
     * 解析条码
     * @param codeBarParam 条码值
     * @return 解析结果集合
     */
    List<ICodeBar> parseCodeBar(HashMap<String,Object> codeBarParam);
}
