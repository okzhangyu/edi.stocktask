package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.codeBar.CodeBar;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.repository.IBORepositoryCodeBar;
import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

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
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/codebar")
    @Override
    public Result<CodeBar> parseCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                        @QueryParam(StockTaskServicePath.SERVICE_CODEBAR)String codeBar) {
        Result<CodeBar> result = new Result<>();
        try{
            List<CodeBar>  resultCodeBar = boRepositoryCodeBar.parseCodeBar(codeBar);
            result = new Result<CodeBar>(ResultCode.OK, ResultDescription.OK,resultCodeBar);
        }catch (Exception e){
            e.printStackTrace();
            result = new Result(ResultCode.FAIL,"failed:"+(e.getCause()==null?e.getMessage():e.getCause().toString()),null);
        }
        return result;
    }
}
