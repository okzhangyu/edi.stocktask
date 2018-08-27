package org.edi.stocktask.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.freamwork.httpclient.HttpRequest;
import org.edi.freamwork.log.LoggerUtils;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskData;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.dto.DocumentSyncResult;
import org.edi.stocktask.repository.BORepositoryStockReport;
import org.edi.stocktask.util.PageVerification;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/31
 */
@Path("/v1")
public class StockReportService implements IStockReportService{
    Logger logger = LoggerUtils.Logger(StockTaskData.APPENDER_NAME);

    @Autowired
    private BORepositoryStockReport boRepositoryStockReport;



    /**
     * 库存任务汇报清单
     * @param token
     * @return
     */
    @UserRequest
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport")
    @Override
    public Result<StockReport> fetchStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                @QueryParam(StockTaskServicePath.SERVICE_SEARCH_PARAMETER)String param,
                                                @QueryParam(ServicePath.SERVICE_BEGININDEX)int beginIndex,
                                                @QueryParam(ServicePath.SERVICE_LIMIT)int limit,
                                                @QueryParam(ServicePath.SERVICE_DOCSTATUS)List<String> docStatus,
                                                @QueryParam(ServicePath.SERVICE_BASEENTRY)int baseEntry) {
        Result result;
        try {
            limit = PageVerification.limitCalculation(beginIndex,limit);
            List<StockReport> stockReports = boRepositoryStockReport.fetchStockReport(token,param,beginIndex==0?1:beginIndex,limit,docStatus,baseEntry);
            if (stockReports.size()==0){
                result = new Result(ResultCode.SUCCESS, StockOpResultDescription.REPORT_IS_EMPTY,stockReports);
            }else {
                result = new Result(ResultCode.SUCCESS, ResultDescription.OP_SUCCESSFUL, stockReports);
            }
        }catch (Exception e){
            result = new Result(ResultCode.FAIL, "failed:" + e.getCause(), null);
        }
        return result;
    }


    /**
     * 保存库存任务汇报
     * @param token
     * @param stockReport
     * @return
     */
    @UserRequest
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport")
    @Override
    public Result saveStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,StockReport stockReport) {
        Result result ;
        try {
            logger.info(StockTaskData.STOCKREPORT_SAVE_INFO + stockReport.toString());
            boRepositoryStockReport.saveStockReport(token,stockReport);
            result = new Result(ResultCode.SUCCESS, ResultDescription.OP_SUCCESSFUL, null);
        } catch (BusinessException e) {
            result = new Result(e);
        }catch (BusinessObjectException e) {
            result = new Result(e);
        }catch (DBException e){
            result = new Result(e);
        }catch (Exception e){
            result = new Result(e);
        }
        logger.info(StockTaskData.STOCKREPORT_SAVE_RETURN_INFO + result.toString());
        return result;
    }

    /**
     * 更新任务汇报
     * @param token
     * @param stockReport
     * @return
     */
    @UserRequest
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport")
    @Override
    public Result updateStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token, StockReport stockReport) {
        Result result ;
        try {
            logger.info(StockTaskData.STOCKREPORT_UPDATE_INFO + stockReport.toString());
            boRepositoryStockReport.updateStockReport(token,stockReport);
            result = new Result(ResultCode.SUCCESS, ResultDescription.OP_SUCCESSFUL,null);
        }catch (BusinessException e){
            result = new Result(e);
        }catch (BusinessObjectException e) {
            result = new Result(e);
        } catch (DBException e){
            result = new Result(e);
        }catch (Exception e) {
            result = new Result(e);
        }
        logger.info(StockTaskData.STOCKREPORT_UPDATE_RETURN_INFO + result.toString());
        return result;
    }


    /**
     * 删除库存任务汇报
     * @param token
     * @param docEntry
     * @return
     */
    @UserRequest
    @DELETE
    @Path("/stockreport")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Result deleteStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,@QueryParam("docEntry")int docEntry) {
        try {
            boRepositoryStockReport.deleteStockReport(docEntry);
            return new Result(ResultCode.SUCCESS, ResultDescription.OP_SUCCESSFUL, null);
        } catch (BusinessException e){
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            return new Result(e);
        }catch (DBException e){
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            return new Result(e);
        }catch (Exception e) {
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            return new Result(ResultCode.FAIL, e);
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport/sync")
    @Override
    public Result syncStockReportToB1(@QueryParam(ServicePath.TOKEN_NAMER)String token, List<StockReport> stockReports) {
        try{
            logger.info(StockTaskData.STOCKREPORT_SYNC_INFO + stockReports.toString());
            Gson gson = new Gson();
            String orderJson = gson .toJson(stockReports);
            String resultMsg = HttpRequest.post(orderJson);
            Result<DocumentSyncResult> resultOpResult = gson.fromJson(resultMsg,new TypeToken<Result<DocumentSyncResult>>(){}.getType());
            logger.info(StockTaskData.STOCKREPORT_SYNC_RETURN_INFO + resultOpResult.toString());
            return resultOpResult;
        }catch (Exception e){
            logger.info(StockTaskData.OPREATION_EXCEPTION,e);
            return new Result(ResultCode.NET_CONNECT_ERROR,ResultDescription.NET_CONNECT_ERROR);
        }
    }


}
