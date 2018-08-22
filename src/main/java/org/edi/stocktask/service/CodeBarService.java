package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import org.apache.log4j.Logger;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.dto.CodeBarParam;
import org.edi.stocktask.repository.IBORepositoryCodeBar;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
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
                                         @QueryParam(StockTaskServicePath.SERVICE_BASELINE)int baseLine,
                                         @QueryParam(StockTaskServicePath.SERVICE_ITEMCODE)String itemCode){
        Result<ICodeBar> result;
        try{
            List<ICodeBar>  resultCodeBar = boRepositoryCodeBar.parseCodeBar(codeBar,baseType,baseEntry,baseLine,itemCode);
            if (resultCodeBar.size()==0){
                result = new Result(ResultCode.SUCCESS, StockOpResultDescription.CODEBARINFO_IS_EMPTY,resultCodeBar);
            }else {
                result = new Result<>(ResultCode.SUCCESS, ResultDescription.OK,resultCodeBar);
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
     * @param codeBarParam 条码集合
     * @return
     */
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/codebars")
//    @Override
//    public Result<CodeBarResult> parseBatchCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token,CodeBarParam  codeBarParam) {
//        Result<CodeBarResult> result;
//        try{
//            if(codeBarParam == null){
//                throw new BusinessObjectException(StockOpResultCode.STOCK_CODEBAR_IS_NULL,StockOpResultDescription.STOCK_CODEBAR_IS_EMPTY);
//            }
//            List<CodeBarResult> batchCodeBarList= boRepositoryCodeBar.parseBatchCodeBar(codeBarParam);
//            result = new Result<>(ResultCode.SUCCESS, ResultDescription.OK,batchCodeBarList);
//        }catch (BusinessException e){
//            log.warn(e);
//            return new Result(e);
//        }catch (DBException e){
//            return new Result<>(e);
//        }
//        catch (Exception e){
//            log.warn(e);
//            return new Result(e);
//        }
//        return result;
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/codebars")
    @Override
    public Result<StockReportItem> parseBatchCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token, CodeBarParam  codeBarParam) {
        Result<StockReportItem> result;
        try{
            if(codeBarParam == null){
                throw new BusinessObjectException(StockOpResultCode.STOCK_CODEBAR_IS_NULL,StockOpResultDescription.STOCK_CODEBAR_IS_EMPTY);
            }
            List<StockReportItem> stockReportItemList= boRepositoryCodeBar.parseBatchCodeBar(codeBarParam);
            result = new Result<>(ResultCode.SUCCESS, ResultDescription.OK,stockReportItemList);
        }catch (BusinessException e){
            log.warn(e);
            return new Result(e);
        }catch (DBException e){
            log.warn(e);
            return new Result<>(e);
        }
        catch (Exception e){
            log.warn(e);
            return new Result(e);
        }
        return result;
    }
}
