package org.edi.stocktask.service;

/**
 * @author Fancy
 * @date 2018/7/10
 */

import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.freamwork.log.LoggerUtils;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.codeBar.ICodeBar;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.data.StockOpResultCode;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.dto.CodeBarParam;
import org.edi.stocktask.dto.ItemCodeQuantity;
import org.edi.stocktask.repository.IBORepositoryCodeBar;
import org.slf4j.Logger;
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
    Logger logger = LoggerUtils.Logger(StockTaskData.APPENDER_NAME);

    @Autowired
    private IBORepositoryCodeBar boRepositoryCodeBar;


    /**
     * 加强解析条码
     * @param codeBar 条码值
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/codebar")
    @Override
    public Result<ICodeBar> strengthenParseCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                   @QueryParam(StockTaskServicePath.SERVICE_CODEBAR)String codeBar,
                                                   @QueryParam(StockTaskServicePath.SERVICE_BASETYPE)String baseType,
                                                   @QueryParam(StockTaskServicePath.SERVICE_BASEENTRY)int baseEntry,
                                                   @QueryParam(StockTaskServicePath.SERVICE_BASELINE)int baseLine,
                                                   @QueryParam(StockTaskServicePath.SERVICE_ITEMCODE)String itemCode,
                                                  CodeBarParam codeBarParam){
        Result<ICodeBar> result;
        try{
            logger.info(StockTaskData.CODEBAR_PARSE_INFO + StockTaskServicePath.SERVICE_CODEBAR + codeBar +";" +
                    StockTaskServicePath.SERVICE_BASETYPE + baseType + ";" +
                    StockTaskServicePath.SERVICE_BASEENTRY + baseEntry + ";" +
                    StockTaskServicePath.SERVICE_BASELINE + baseLine + ";" +
                    StockTaskServicePath.SERVICE_ITEMCODE + itemCode + ";" +
                    "CodeBarParam" + codeBarParam.toString() + ";");
            List<ICodeBar>  resultCodeBar = boRepositoryCodeBar.strengthenParseCodeBar(codeBar,baseType,baseEntry,baseLine,itemCode,codeBarParam);
            if (resultCodeBar.size()==0){
                result = new Result(ResultCode.SUCCESS, StockOpResultDescription.CODEBARINFO_IS_EMPTY,resultCodeBar);
            }else {
                result = new Result<>(ResultCode.SUCCESS, ResultDescription.OK,resultCodeBar);
            }
        }catch(BusinessException e){
            logger.error("解析发生业务异常",e);
            result = new Result(e);
        }catch (Exception e){
            logger.error("解析发生异常",e);
            result = new Result(e);
        }
        logger.info(StockTaskData.CODEBAR_PARSE_RESULT + result.toString());
        return result;
    }

    /**
     * 批量解析条码
     * @param token
     * @param codeBarParam 条码集合
     * @return
     */

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/codebars")
    @Override
    public Result<StockReportItem> parseBatchCodeBar(@QueryParam(ServicePath.TOKEN_NAMER)String token, CodeBarParam  codeBarParam) {
        Result<StockReportItem> result;
        try{
            logger.info(StockTaskData.CODEBARS_PARSE_INFO + codeBarParam.toString());
            if(codeBarParam == null){
                throw new BusinessObjectException(StockOpResultCode.STOCK_CODEBAR_IS_NULL,StockOpResultDescription.STOCK_CODEBAR_IS_EMPTY);
            }
            List<StockReportItem> stockReportItemList= boRepositoryCodeBar.parseBatchCodeBar(codeBarParam);
            result = new Result<>(ResultCode.SUCCESS, ResultDescription.OK,stockReportItemList);
        }catch (BusinessException e){
            logger.error("批量解析发生业务异常",e);
            return new Result(e);
        }catch (DBException e){
            logger.error("批量解析发生数据库异常",e);
            return new Result<>(e);
        }catch (Exception e){
            logger.error("批量解析发生异常",e);
            return new Result(e);
        }
        logger.info(StockTaskData.CODEBARS_PARSE_RESULT + result.toString());
        return result;
    }
}
