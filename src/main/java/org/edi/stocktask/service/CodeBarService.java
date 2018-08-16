package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import org.apache.log4j.Logger;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
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
                                         @QueryParam(StockTaskServicePath.SERVICE_CODEBAR)String codeBar,
                                         @QueryParam(StockTaskServicePath.SERVICE_BASETYPE)String baseType,
                                         @QueryParam(StockTaskServicePath.SERVICE_BASEENTRY)int baseEntry,
                                         @QueryParam(StockTaskServicePath.SERVICE_BASELINE)int baseLine) {
        Result<ICodeBar> result;
        try{
            List<ICodeBar>  resultCodeBar = boRepositoryCodeBar.parseCodeBar(codeBar,baseType,baseEntry,baseLine);
            if (resultCodeBar.size()==0){
                result = new Result(ResultCode.OK, ResultDescription.CODEBARINFO_IS_EMPTY,resultCodeBar);
            }else {
                result = new Result<>(ResultCode.OK, ResultDescription.OK,resultCodeBar);
            }
        }catch (BusinessException e){
            log.warn(e);
            result = new Result(e);
        }catch (Exception e){
            log.warn(e);
            result = new Result(e);
        }
        return result;
    }

    /**
     * 批量解析条码
     * @param token
     * @param codeBars 条码集合
     * @return
     */
    @Override
    public Result<StockReportItem> parseBatchCodeBar(String token, List<String> codeBars) {
        Result<StockReportItem> result = null;
        try{
            if(codeBars == null || codeBars.size() == 0){
                throw new BusinessObjectException(StockOpResultCode.STOCK_CODEBAR_IS_NULL,StockOpResultDescription.STOCK_CODEBAR_IS_EMPTY);
            }
            //检查codebar是否有重复项


        }catch (BusinessException e){
            result = new Result<>(e);
        }catch (Exception e){
            result = new Result<>(e);
        }
        return null;
    }
}
