package repository;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.bo.stocktask.IStockTask;
import org.edi.stocktask.bo.stocktask.StockTask;
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


    private String B1DocEntry = "1";
    private IStockTask stockTask;
    private StockReport stockReport;
    private List<StockReport> stockReports = new ArrayList<>();

    private StockReport getStockReport() throws Exception{
        if(stockReport == null){
            testSaveStockReport();
        }
        return stockReport;
    }

    @Test
    public void testSaveStockReport() throws Exception{
        List<IStockTask> stockTasks = boRepositoryStockTask.fetchStockTask("");
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
    public void testFetchStockReportByEntry() throws Exception {
        StockReport stockReport = boRepositoryStockReport.fetchStockReportByEntry(getStockReport().getDocEntry());
        //StockReport stockReport = boRepositoryStockReport.fetchStockReportByEntry()
        Assert.assertEquals(getStockReport().getDocEntry(),stockReport.getDocEntry());
        Assert.assertEquals(getStockReport(),stockReport);
    }

    @Test
    public void testUpdateDocStatus() throws Exception{
        //boRepositoryStockReport.updateStockReportDocStatus(B1DocEntry, getStockReport().getDocEntry());
        StockReport stockReport  = getStockReport();
        stockReport.setB1DocEntry(B1DocEntry);
        stockReport.setDocumentStatus("C");
        boRepositoryStockReport.updateStockReportDocStatus(stockReport);
        stockReport = boRepositoryStockReport.fetchStockReportByEntry(this.stockReport.getDocEntry());
        Assert.assertEquals("C",stockReport.getDocumentStatus());
        Assert.assertEquals(B1DocEntry,stockReport.getB1DocEntry());
    }
}