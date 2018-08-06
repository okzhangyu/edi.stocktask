package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import org.apache.log4j.Logger;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.repository.IBORepositoryCodeBar;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 条码相关服务
 */
@Path("/v1")
@UserRequest
public class CodeBarService implements ICodeBarService{
    private static Logger log = Logger.getLogger(CodeBarService.class);



    @Autowired
    private IBORepositoryCodeBar boRepositoryCodeBar;

    /**
     * 解析条码
     * @param codeBar 条码值
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/codebar")
    @Override
    public Result<ICodeBar> parseCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                         @QueryParam(StockTaskServicePath.SERVICE_CODEBAR)String codeBar) {
        Result<ICodeBar> result;
        try{
            List<ICodeBar>  resultCodeBar = boRepositoryCodeBar.parseCodeBar(codeBar);
            result = new Result<>(ResultCode.OK, ResultDescription.OK,resultCodeBar);
        }catch (Exception e){
            log.warn(e);
            result = new Result(ResultCode.FAIL,e);
        }
        return result;
    }
}
