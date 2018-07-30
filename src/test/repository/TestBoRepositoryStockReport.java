package repository;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;
import org.edi.stocktask.repository.BORepositoryCodeBar;
import org.edi.stocktask.repository.IBORepositoryStockReport;
import org.edi.stocktask.repository.IBORepositoryStockTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBoRepositoryStockReport extends TestCase{

    @Autowired
    private IBORepositoryStockTask boRepositoryStockTask;

    @Autowired
    private IBORepositoryStockReport boRepositoryStockReport;

    @Autowired
    private BORepositoryCodeBar boRepositoryCodeBar;



    private StockTask stockTask;
    private StockReport stockReport;
    private List<StockReport> stockReports = new ArrayList<>();

    private StockReport getStockReport() throws Exception{
        if(stockReport == null){
            this.testSaveStockReport();
        }
        return stockReport;
    }



    /**
     * 条码解析
     * @return
     */

    @Test
    public void testParseCodeBar()throws Exception{
      System.out.print(boRepositoryCodeBar.parseCodeBar("123456789963"));
    }


    /**
     * 库存任务
     * @return
     * */

    @Test
    public void testfetchStockTask() throws Exception{
        List<StockTask> stockTasks = boRepositoryStockTask.fetchStockTask("");
        if(stockTasks.size() > 0){
            if(stockTasks == null){
                stockTask = stockTasks.get(0);
            }
        }
    }



    @Test
    public void testFetchStockTaskItem() throws Exception{
        List<StockTaskItem>  stockTaskItemList = boRepositoryStockTask.fetchAllStockTaskItem();
        for (int i=0;i<stockTaskItemList.size();i++){
            System.out.println(stockTaskItemList.get(i).toString());
        }

    }


    @Test
    public void testFetchStockTaskByCondition() throws Exception{
       List<StockTask>  stockTaskItemList = boRepositoryStockTask.fetchStockTaskByCondition(155,"202");
        for (int i=0;i<stockTaskItemList.size();i++){
            System.out.println(stockTaskItemList.get(i).toString());
        }

    }


    /**
     * 库存任务汇报
     * @return
     * */
    @Test
    public void testFetchStockReport(){
        List<StockReport> stockReportList = boRepositoryStockReport.fetchStockReport("");
        if(stockReportList.size() > 0){
            if(stockReport == null){
                stockReport = stockReportList.get(0);
            }
        }
    }



    @Test
    public void testFetchStockReportByEntry() throws Exception {
        StockReport stockReport = boRepositoryStockReport.fetchStockReportByEntry(getStockReport().getDocEntry());
        Assert.assertEquals(getStockReport().getDocEntry(),stockReport.getDocEntry());
    }





    @Test
    public void testSaveStockReport() throws Exception{
        List<StockTask> stockTasks = boRepositoryStockTask.fetchStockTask("");
        if(stockTasks.size() > 0){
            if(stockTasks != null){
                stockTask = stockTasks.get(0);
            }
            if(stockReport == null){
                stockReport  = StockReport.createStockReport(stockTask);
                stockReports.add(stockReport);
            }
            boRepositoryStockReport.saveStockReports(stockReports);
        }
    }

    @Test
    public void testDeleteStockReport(){
             boRepositoryStockReport.deleteStockReport(4);
    }



    @Test
    public void testFetchStockReportFuzzy(){
        List<StockReport> stockReportList = boRepositoryStockReport.fetchStockReportFuzzy("yy");
        if(stockReportList.size() > 0){
            if(stockReport == null){
                stockReport = stockReportList.get(0);
            }
        }
    }

    @Test
    public void testFetchUnSyncStockReport(){
        List<StockReport> stockReportList = boRepositoryStockReport.fetchUnSyncStockReport();
        if(stockReportList.size() > 0){
            if(stockReport == null){
                stockReport = stockReportList.get(0);
            }
        }
    }



    @Test
    public void testFetchStockReportByCondition(){
        List<StockReport> stockReportList = boRepositoryStockReport.fetchStockReportByCondition("大连威海公司","","");
        if(stockReportList.size() > 0){
            if(stockReport == null){
                stockReport = stockReportList.get(0);
            }
        }
    }
}
