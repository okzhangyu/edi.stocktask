package org.edi.stocktask.service;


import org.apache.log4j.Logger;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.util.CharsetConvert;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.repository.IBOReposirotyStockReport;
import org.glassfish.jersey.server.JSONP;
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
    private IBOReposirotyStockReport boReposirotyStockReport;



    /**
     * 库存任务汇报清单
     * @param token
     * @return
     */
    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stockreports")
    @Override
    public Result<StockReport> fetchStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token) {
        Result result = new Result();
      try {
            List<StockReport> StockReports = boReposirotyStockReport.fetchStockReport();
            result = new Result("0", "ok", StockReports);
        } catch (Exception e){
          e.printStackTrace();
          result = new Result("1", "failed:" + e.getCause(), null);
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
        log.info("parameter info:" + stockReports);
        Result result = new Result();
            if (stockReports.size() > 0) {
                try {
                    boReposirotyStockReport.saveStockReports(stockReports);
                    result = new Result("0", "ok", null);
                } catch (Exception e) {
                    result = new Result("1", "failed:" + e.getCause(), null);
                }
            } else {
                result = new Result("1", "failed:"+ CharsetConvert.convert("参数信息为空!"), null);
            }
        return result;
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
        Result result = new Result();
        if (stockReports.size() > 0) {
            try {
                boReposirotyStockReport.updateStockReport(stockReports);
                result = new Result("0", "ok", null);
            } catch (Exception e) {
                result = new Result("1", "failed:" + (e.getCause()==null?e.getMessage():e.getCause().toString()), null);
            }
        } else {
            result = new Result("1", "failed:"+ CharsetConvert.convert("参数信息为空!"), null);
        }
        return result;
    }


    /**
     * 删除库存任务汇报
     * @param token
     * @param docEntry
     * @return
     */

    @DELETE
    @Path("/stockreports")
    @Override
    public Result deleteStockReport(@QueryParam(ServicePath.TOKEN_NAMER)String token,@QueryParam("docEntry")int docEntry) {
        Result result = new Result();
            try {
                boReposirotyStockReport.deleteStockReport(docEntry);
                result = new Result("0","ok",null);
            }catch (Exception e){
                e.printStackTrace();
                result = new Result("1","failed:"+(e.getCause()==null?e.getMessage():e.getCause().toString()),null);
            }
       return  result;
    }



}
