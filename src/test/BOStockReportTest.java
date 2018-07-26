import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.freamwork.data.DateTime;
import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.util.CharsetConvert;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.mapper.StockReportMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 2018/7/23.
 * 任务汇报单元测试
 */
public class BOStockReportTest {

    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        return openSession;
    }

    public StockReportMapper getStockReportMapper() throws IOException {
        StockReportMapper stockReportMapper=getSqlSession().getMapper(StockReportMapper.class);
        return stockReportMapper;
    }

    /**
     * 构建任务汇报对象
     * @return
     */
     public List<StockReport> stockReports(){
         List<StockReport> stockReportList = new ArrayList<>();
         List<StockReportItem> stockReportItemList = new ArrayList<>();
         StockReportItem stockReportItem = new StockReportItem();
         stockReportItem.setDocEntry(235);
         stockReportItem.setReference1("中石化汇报单元");
         stockReportItem.setReference2("中石化汇报单元");
         stockReportItem.setBaseDocumentType("A");
         stockReportItem.setBaseDocumentEntry(1);
         stockReportItem.setItemDescription("中石化汇报单元");
         stockReportItem.setQuantity(1.0);
         stockReportItem.setBatchNumberManagement("P");
         stockReportItem.setBatchNumber("32");
         stockReportItem.setFromLocation("北京");
         stockReportItem.setFromLocation("中石化");
         stockReportItem.setToWarehouse("上海");
         stockReportItem.setToLocation("深圳");
         StockReportItem stockReportItem2 = new StockReportItem();
         stockReportItem2.setDocEntry(235);
         stockReportItem2.setReference1("中石化汇报单元");
         stockReportItem2.setReference2("中石化汇报单元");
         stockReportItem2.setBaseDocumentType("A");
         stockReportItem2.setBaseDocumentEntry(1);
         stockReportItem2.setItemDescription("中石化汇报单元");
         stockReportItem2.setQuantity(2.0);
         stockReportItem2.setBatchNumberManagement("P");
         stockReportItem2.setBatchNumber("32");
         stockReportItem2.setFromLocation("北京");
         stockReportItem2.setFromLocation("中石化");
         stockReportItem2.setToWarehouse("上海");
         stockReportItem2.setToLocation("深圳");
         stockReportItemList.add(stockReportItem);
         stockReportItemList.add(stockReportItem2);

         StockReport stockReport = new StockReport();
         stockReport.setCompanyName("中石化单元测试用例编写");
         stockReport.setDocEntry(235);
         stockReport.setPeriod("1");
         stockReport.setObjectCode("DF20180604");
         stockReport.setTransfered("F");
         stockReport.setRemarks("单元测试用例");
         stockReport.setBydUUID("3697459");
         stockReport.setObjectCode("DF20180604");
         stockReport.setB1DocEntry(0);
         stockReport.setStockReportItems(stockReportItemList);
         stockReportList.add(stockReport);
         return  stockReportList;
     }
    /**
     * 查询任务汇报清单
     * @return
     */

    public List<StockReport> fetchStockReport(String param)throws IOException{
        List<StockReport> stockReports;
        if(param!=null && !param.isEmpty()){
            stockReports = getStockReportMapper().fetchStockReportFuzzy(param);
        }else {
            stockReports = getStockReportMapper().fetchStockReport();
        }
        if(stockReports.size() == 0) {
            return stockReports;
        }
        for(int i=0;i<stockReports.size();i++){
            StockReport stockReport = stockReports.get(i);
            List<StockReportItem> stockReportItems = getStockReportMapper().fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(stockReportItems);
        }
        return stockReports;
    }



    /**
     * 根据DOCENTRY查询库存任务汇报
     * @param docEntry
     * @return
     */

    public StockReport fetchStockReportByEntry(Integer docEntry)throws IOException{
        StockReport stockReport = getStockReportMapper().fetchStockReportByEntry(docEntry);
        List<StockReportItem> stockReportItems = getStockReportMapper().fetchStockReportItem(docEntry);
        stockReport.setStockReportItems(stockReportItems);
        return stockReport;
    }
    /**
     * 条件查询任务汇报
     * @param companyName
     * @param baseDocumentType
     * @param baseDocumentEntry
     * @return
     */

    public List<StockReport> fetchStockReportByCondition(String companyName, String baseDocumentType, String baseDocumentEntry)throws IOException {
        HashMap<String,String> stockReportCondition = new HashMap<>();
        stockReportCondition.put("companyName",companyName);
        stockReportCondition.put("baseDocumentType",baseDocumentType);
        stockReportCondition.put("baseDocumentEntry",baseDocumentEntry);
        List<StockReport> StockReports = getStockReportMapper().fetchStockReportByCondition(stockReportCondition);
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = getStockReportMapper().fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        return StockReports;
    }




    /**
     * 模糊查询库存任务汇报
     * @param value
     * @return
     */
    public List<StockReport> fetchStockReportFuzzy(String value)throws IOException{
        List<StockReport> StockReports = getStockReportMapper().fetchStockReportFuzzy(value);
        for(int i=0;i<StockReports.size();i++){
            StockReport stockReport = StockReports.get(i);
            List<StockReportItem> StockReportItems = getStockReportMapper().fetchStockReportItem(stockReport.getDocEntry());
            stockReport.setStockReportItems(StockReportItems);
        }
        return StockReports;
    }

    /**
     * 保存任务汇报
     * @param stockReports
     * @return
     */
    public void saveStockReports(List<StockReport> stockReports) throws Exception{
        try {
        for (int i = 0; i < stockReports.size(); i++) {
            int docEntry = getStockReportMapper().fetchSequenceOfDocEntry();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate=sdf.format(new Date());
            StockReport stockReport = stockReports.get(i);
            stockReport.setDocEntry(docEntry);
            //stockReport.setCreateDate(DateTime.getToday());
            getStockReportMapper().saveStockReport(stockReport);
            for (int j = 0; j < stockReports.get(i).getStockReportItems().size(); j++) {
                StockReportItem stockReportItem = stockReports.get(i).getStockReportItems().get(j);
                stockReportItem.setDocEntry(docEntry);
                stockReportItem.setLineId(j + 1);
                getStockReportMapper().saveStockReportItem(stockReportItem);
            }
        }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
            }
    }


    /**
     * 更新库存任务汇报
     * @param stockReports
     * @return
     */
    public void updateStockReport(List<StockReport> stockReports) throws IOException{
        for (int i=0;i<stockReports.size();i++){
            StockReport stockReport = stockReports.get(i);
            if(stockReport.getB1DocEntry()==null||stockReport.getB1DocEntry().equals("")||stockReport.getB1DocEntry()==0){
                try {
                    getStockReportMapper().updateStockReport(stockReport);
                    for(int j=0;j<stockReport.getStockReportItems().size();j++){
                        StockReportItem stockReportItem = stockReport.getStockReportItems().get(j);
                        getStockReportMapper().updateStockReportItem(stockReportItem);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    throw e;
                }
            }else{
                throw new BusinessException(CharsetConvert.convert(ResultDescription.B1DOCENTRY_IS_EXISTENT));
            }
        }

    }




    /**
     * 删除任务汇报
     * @param docEntry
     * @return
     */
    public void deleteStockReport(Integer docEntry) throws IOException{
        StockReport stockReport = getStockReportMapper().fetchStockReportByEntry(docEntry);
        if(stockReport.getB1DocEntry()==null||stockReport.getB1DocEntry().equals("")||stockReport.getB1DocEntry()==0){
            try {
                getStockReportMapper().deleteStockReport(docEntry);
                getStockReportMapper().deleteStockReportItem(docEntry);
            }catch(Exception e){
                e.printStackTrace();
                throw e;
            }
        }else{
            throw new BusinessException(CharsetConvert.convert(ResultDescription.B1DOCENTRY_IS_EXISTENT));
        }

    }



    @Test
    public void fetchStockReportTest() throws IOException {
        List<StockReport> stockReports = fetchStockReport(null);
            for (StockReport stockReport:stockReports) {
                System.out.println(stockReport.toString());
            }
    }



    @Test
    public void fetchStockReportByEntryTest() throws IOException {
            StockReport stockReport = fetchStockReportByEntry(160);
                System.out.println(stockReport.toString());
    }



    @Test
    public void fetchStockReportByConditionTest()throws IOException{
        List<StockReport> StockReports = fetchStockReportByCondition("","","36");
        for (StockReport stockReport:StockReports) {
            System.out.println(stockReport.toString());
        }
    }




    @Test
    public void fetchStockReportFuzzyTest() throws IOException{
        List<StockReport> StockReports = fetchStockReportFuzzy("26");
        for (StockReport stockReport:StockReports) {
            System.out.println(stockReport.toString());
        }
    }




    @Test
    public void saveStockReportsTest() throws Exception {
        List<StockReport> stockReports = stockReports();
        saveStockReports(stockReports);
    }




    @Test
    public void updateStockReportsTest() throws IOException {
        List<StockReport> stockReports = stockReports();
       updateStockReport(stockReports);
    }



    @Test
    public void deleteStockReportTest() throws IOException {
       deleteStockReport(268);
    }


    @Test
    public void closeSession()throws IOException{
        getSqlSession().close();
    }

}
