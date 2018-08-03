package org.edi.stocktask.service;


import org.apache.log4j.Logger;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.data.StockTaskServicePath;
import org.edi.stocktask.repository.BORepositoryStockReport;
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
@UserRequest
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
    @Path("/stockreports")
    @Override
    public Result<StockReport> fetchStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,
                                                @QueryParam(StockTaskServicePath.SERVICE_SEARCH_PARAMETER)String param) {
        Result result;
        try {
            List<StockReport> stockReports = boRepositoryStockReport.fetchStockReport(param);
            result = new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL,stockReports);
        }catch (Exception e){
          e.printStackTrace();
          result = new Result(ResultCode.FAIL, "failed:" + e.getCause(), null);
        }
        return result;
    }


    /**
     * 保存库存任务汇报
     * @param token
     * @param stockReports
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    @Override
    public Result saveStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,List<StockReport> stockReports) {
       if (!ReportVerification.reportCheck(stockReports).equals("ok")){
           return new Result(ResultCode.OK, ReportVerification.reportCheck(stockReports), null);
       }
        try {
            boRepositoryStockReport.saveStockReports(stockReports);
            return new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL, null);
        } catch (BusinessObjectException e) {
            return new Result(e);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.FAIL, e);
        }
    }

    /**
     * 更新任务汇报
     * @param token
     * @param stockReports
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    @Override
    public Result updateStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token, List<StockReport> stockReports) {
        log.info("parameter info:" + stockReports);
        if (!ReportVerification.reportCheck(stockReports).equals("ok")){
            return new Result(ResultCode.OK, ReportVerification.reportCheck(stockReports), null);
        }
        try {
            boRepositoryStockReport.updateStockReport(stockReports);
            return new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL,null);
        }catch (BusinessObjectException e){
            return new Result(e);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.FAIL,e);
        }
    }


    /**
     * 删除库存任务汇报
     * @param token
     * @param docEntry
     * @return
     */
    @DELETE
    @Path("/stockreports")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Result deleteStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,@QueryParam("docEntry")int docEntry) {
        try {
            boRepositoryStockReport.deleteStockReport(docEntry);
            return new Result(ResultCode.OK, ResultDescription.OP_SUCCESSFUL, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.FAIL, e);
        }
    }


}
