package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import javax.ws.rs.GET;
import java.util.HashMap;

/**
 * 条码相关服务
 */
public class CodeBarService implements ICodeBarService{

    /**
     * 解析条码
     * @param codeBar
     * @return
     */
    @GET
    @Override
    public HashMap<String, String> parseCodeBar(String token,String codeBar) {
        return null;
    }
}
