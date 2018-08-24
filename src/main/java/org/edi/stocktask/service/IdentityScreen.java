package org.edi.stocktask.service;

import org.edi.initialfantasy.bo.user.User;
import org.edi.stocktask.bo.stockreport.StockReport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/8/23.
 */


public class IdentityScreen {



    public static List<StockReport> stockReportListIdentity(User user, List<StockReport> stockReports, List<String> docStatusList){
        List<StockReport> stockReportList = new ArrayList<>();
        if(user.getIsSupperUser().trim().equals("Y")){
            for (String docStatus:docStatusList) {
                for (int i=0;i<stockReports.size();i++){
                    if(stockReports.get(i).getDocumentStatus().trim().equals(docStatus)){
                        stockReportList.add(stockReports.get(i));
                    }
                }
            }
        }else{
            List<StockReport> reports = new ArrayList<>();
            for (int i=0;i<stockReports.size();i++){
                if(stockReports.get(i).getCreateUserSign().trim().equals(user.getUserName())){
                    reports.add(stockReports.get(i));
                }
            }
            for (String docStatus:docStatusList) {
                for (int i=0;i<reports.size();i++){
                    if(reports.get(i).getDocumentStatus().trim().equals(docStatus)){
                        stockReportList.add(reports.get(i));
                    }
                }
            }
        }

        /*if(user.getIsSupperUser().trim().equals("Y")){
            for (String docStatus:docStatusList) {
                List<StockReport> stockReportListItem = stockReports.stream()
                        .filter(c->c.getDocumentStatus().equals(docStatus))
                        .collect(Collectors.toList());
                stockReportList.addAll(stockReportListItem);
            }
        }else{
            stockReports = stockReports.stream().filter(c->c.getCreateUserSign().equals(user.getUserName())).collect(Collectors.toList());
            for (String docStatus:docStatusList) {
                List<StockReport> stockReportListItem = stockReports.stream().filter(c->c.getDocumentStatus().equals(docStatus)).collect(Collectors.toList());
               stockReportList.addAll(stockReportListItem);
            }
        }*/
        return stockReportList;
    }

   /* public List<IStockTask> stockTaskListIdentity(String token, List<IStockTask> stockTasks, List<String> docStatusList){
        User user = getUserIdentity(token);
        List<IStockTask> stockTaskList = new ArrayList<>();
        if(user.getIsSupperUser().trim().equals("Y")){
            for (String docStatus:docStatusList) {
                stockTaskList = stockTasks.stream().filter(c->c.getDocumentStatus().equals(docStatus)).collect(Collectors.toList());
                stockTaskList.addAll(stockTaskList);
            }
        }else{
            stockTaskList = stockTasks.stream().filter(c->c.getReporterId().equals(user.getUserName())).collect(Collectors.toList());
            for (String docStatus:docStatusList) {
                stockTaskList = stockTasks.stream().filter(c->c.getDocumentStatus().equals(docStatus)).collect(Collectors.toList());
                stockTaskList.addAll(stockTaskList);
            }
        }
        return stockTaskList;
    }*/

}
