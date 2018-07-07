package org.edi.stocktask.service;


import org.apache.log4j.Logger;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.util.CharsetConvert;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.repository.IBOReposirotyStockReport;
import org.edi.stocktask.util.TokenVerification;
import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
    private IBOReposirotyStockReport boReposirotyStockReport;
    @Autowired
    private PlatformTransactionManager ptm;
    @Autowired
    private TokenVerification tokenVerification;

    /**
     * 查询库存任务汇报
     * @param token
     * @return
     */
    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/stockreports")
    @Override
    public Result<StockReport> fetchStockReport(@QueryParam("token")String token) {
        Result result = new Result();
        String msg = tokenVerification.verification(token);
        if (msg.equals("ok")) {
            List<StockReport> StockReports = boReposirotyStockReport.fetchStockReport();
            result = new Result("0", "ok", StockReports);
        } else {
            result = new Result("1", "failed:" + msg, null);
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
    public Result saveStockReport(@QueryParam("token")String token,List<StockReport> stockReports) {
        String msg = tokenVerification.verification(token);
        log.info("parameter info:" + stockReports);
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = ptm.getTransaction(def);
        Result result = new Result();
        if(msg.equals("ok")) {
            if (stockReports.size() > 0) {
                try {
                    boReposirotyStockReport.saveStockReports(stockReports);
                    ptm.commit(status);
                    result = new Result("0", "ok!", null);
                } catch (Exception e) {
                    e.printStackTrace();
                    ptm.rollback(status);
                    result = new Result("1", "failed:" + e.getCause(), null);
                }
            } else {
                result = new Result("1", "failed:"+ CharsetConvert.convert("参数信息为空！"), null);
            }
        }else {
            result = new Result("1","failed:"+msg,null);
        }
        return result;
    }

    /**
     * 更新任务汇报
     * @param token
     * @param stockReports
     * @return
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stockreports")
    @Override
    public Result<?> updateStockReport(String token, List<StockReport> stockReports) {
        return null;
    }



}
