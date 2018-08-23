package org.edi.stocktask.service;

import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.repository.BORepositoryUser;
import org.edi.initialfantasy.repository.BORepositoryUserAuth;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by asus on 2018/8/23.
 */

@Component(value="identityScreen")
public class IdentityScreen {

    @Autowired
    private BORepositoryUserAuth boRepositoryUserAuth;

    @Autowired
    private BORepositoryUser boRepositoryUser;


    public User getUserIdentity(String token){
        UserAuth userAuth = boRepositoryUserAuth.serchAuthByToken(token);
        User user = boRepositoryUser.getUserByName(userAuth.getUserId());
        return user;
    }



    public List<StockReport> stockReportListIdentity(String token, List<StockReport> stockReports, List<String> docStatusList){
        User user = getUserIdentity(token);
        List<StockReport> stockReportList = new ArrayList<>();
        if(user.getIsSupperUser().trim().equals("Y")){
            for (String docStatus:docStatusList) {
                List<StockReport> stockReportListItem = stockReports.stream()
                        .filter(c->c.getDocumentStatus().equals(docStatus))
                        .collect(Collectors.toList());
//                stockReportList.addAll(stockReportListItem);
            }
        }else{
//            stockReports = stockReports.stream().filter(c->c.getCreateUserSign().equals(user.getUserName())).collect(Collectors.toList());
//            for (String docStatus:docStatusList) {
//                List<StockReport> stockReportListItem = stockReports.stream().filter(c->c.getDocumentStatus().equals(docStatus)).collect(Collectors.toList());
//               stockReportList.addAll(stockReportListItem);
//            }
        }
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
