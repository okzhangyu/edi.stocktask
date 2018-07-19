package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.jersey.UserRequest;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.stocktask.bo.codeBar.CodeBar;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.repository.IBORepositoryCodeBar;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * 条码相关服务
 */
@Path("/v1")
@UserRequest
public class CodeBarService implements ICodeBarService{

    @Autowired
    private IBORepositoryCodeBar boRepositoryCodeBar;
    /**
     * 解析条码
     * @param codeBar
     * @return
     */
    @GET
    @Override
    public Result<CodeBar> parseCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                        @QueryParam(StockTaskServicePath.SERVICE_CODEBAR)String codeBar) {
        Result<CodeBar> result = new Result<>();
        try{
            boRepositoryCodeBar.parseCodeBar(codeBar);
        }catch (BusinessException ex){

        }
        return result;
    }
}
