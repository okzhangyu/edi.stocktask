package org.edi.stocktask.service;

import java.util.HashMap;

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
    HashMap<String,String> parseCodeBar(String token,String codeBar);
}
