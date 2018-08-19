package org.edi.stocktask.service;


import org.apache.log4j.Logger;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.data.StockOpResultDescription;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.repository.BORepositoryStockReport;
import org.edi.stocktask.util.PageVerification;
import org.edi.stocktask.util.ReportVerification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/31
 */
@Path("/v1")
public class StockReportService implements  IStockReportService{
    private static Logger log = Logger.getLogger(StockReportService.class);

    @Autowired
    private BORepositoryStockReport boRepositoryStockReport;

    /**
     * 库存任务汇报清单
     * @param token
     * @return
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport")
    @Override
    @UserRequest
    public Result<StockReport> fetchStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                @QueryParam(StockTaskServicePath.SERVICE_SEARCH_PARAMETER)String param,
                                                @QueryParam(ServicePath.SERVICE_BEGININDEX)int beginIndex,
                                                @QueryParam(ServicePath.SERVICE_LIMIT)int limit) {
        Result result;
        try {
            limit = PageVerification.limitCalculation(beginIndex,limit);
            List<StockReport> stockReports = boRepositoryStockReport.fetchStockReport(param,beginIndex==0?1:beginIndex,limit);
            if (stockReports.size()==0){
                result = new Result(ResultCode.OK, StockOpResultDescription.REPORT_IS_EMPTY,stockReports);
            }else {
                result = new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL, stockReports);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.warn(e);
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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport")
    @Override
    public Result saveStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,StockReport stockReport) {
        try {
            log.warn(ReportVerification.getReportRecord(stockReport));
            ReportVerification.reportSaveCheck(stockReport);
            boRepositoryStockReport.saveStockReport(stockReport);
            return new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL, null);
        } catch (BusinessException e) {
            log.warn(e);
            return new Result(e);
        }catch (BusinessObjectException e) {
            log.warn(e);
            return new Result(e);
        }catch (DBException e){
            return new Result(e);
        }catch (Exception e){
            e.printStackTrace();
            log.warn(e);
            return new Result(e);
        }
    }

    /**
     * 更新任务汇报
     * @param token
     * @param stockReport
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreport")
    @Override
    public Result updateStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token, StockReport stockReport) {
        try {
            log.warn(ReportVerification.getReportRecord(stockReport));
            ReportVerification.reportUpdateCheck(stockReport);
            boRepositoryStockReport.updateStockReport(stockReport);
            return new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL,null);
        }catch (BusinessException e){
            log.warn(e);
            return new Result(e);
        }catch (BusinessObjectException e) {
            log.warn(e);
            return new Result(e);
        } catch (DBException e){
            return new Result(e);
        }catch (Exception e) {
            e.printStackTrace();
            log.warn(e);
            return new Result(e);
        }
    }


    /**
     * 删除库存任务汇报
     * @param token
     * @param docEntry
     * @return
     */
    @DELETE
    @Path("/stockreport")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Result deleteStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,@QueryParam("docEntry")int docEntry) {
        try {
            boRepositoryStockReport.deleteStockReport(docEntry);
            return new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL, null);
        } catch (BusinessException e){
            log.warn(e);
            return new Result(e);
        }catch (DBException e){
            return new Result(e);
        }catch (Exception e) {
            e.printStackTrace();
            log.warn(e);
            return new Result(ResultCode.FAIL, e);
        }
    }

    @Override
    public Result syncStockReportToB1(String token, List<StockReport> stockReports) {

        return null;
    }


}
