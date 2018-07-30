
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.stocktask.bo.stocktask.StockTask;
import org.edi.stocktask.bo.stocktask.StockTaskItem;
import org.edi.stocktask.mapper.StockTaskMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by asus on 2018/7/23.
 * 库存任务单元测试
 */


public class BOStockTaskTest {

    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        return openSession;
    }
    public StockTaskMapper getStockTaskMapper() throws IOException {
        StockTaskMapper stockTaskMapper=getSqlSession().getMapper(StockTaskMapper.class);
        return stockTaskMapper;
    }

    /**s
     * 查询库存任务
     * @return
     */
    public List<StockTask> fetchStockTask(String param)throws IOException{
        List<StockTask> stockTasks;
        if(param!=null && !param.isEmpty()){
            stockTasks = getStockTaskMapper().fetchStockTaskFuzzy(param);
        }else {
            stockTasks = getStockTaskMapper().fetchStockTask();
        }
        if(stockTasks.size() == 0) {
            return stockTasks;
        }
        for (int i = 0;i<stockTasks.size();i++){
            List<StockTaskItem> stockTaskItems = getStockTaskMapper().fetchStockTaskItem(stockTasks.get(i).getObjectKey());
            if(stockTaskItems!=null){
                stockTasks.get(i).setStockTaskItems(stockTaskItems);
            }
        }
        return stockTasks;
    }

    /**
     * 根据OBJECTKEY查询库存任务明细
     * @param objectKey
     * @return
     */
    public List<StockTaskItem> fetchStockTaskItem(Integer objectKey)throws IOException{
        List<StockTaskItem> stockTaskItems = getStockTaskMapper().fetchStockTaskItem(objectKey);
        return stockTaskItems;
    }

    /**
     * 查询所有库存任务明细
     * @return
     */
    public List<StockTaskItem> fetchAllStockTaskItem()throws IOException{
        List<StockTaskItem> stockTaskItems = getStockTaskMapper().fetchAllStockTaskItem();
        return stockTaskItems;
    }



    @Test
    public void fetchStockTaskTest() throws IOException {
        List<StockTask> stockTasks = fetchStockTask(null);
            for (StockTask stockTask:stockTasks) {
                System.out.println(stockTask.toString());
            }
    }



    @Test
    public void fetchStockTaskItemTest()throws IOException{
            List<StockTaskItem> stockTaskItems = fetchStockTaskItem(160);
            for (StockTaskItem stockTaskItem : stockTaskItems) {
                System.out.println(stockTaskItem.toString());
            }
    }


    @Test
    public void fetchAllStockTaskItemTest()throws IOException{
            List<StockTaskItem> stockTaskItems = fetchAllStockTaskItem();
            for (StockTaskItem stockTaskItem : stockTaskItems) {
                System.out.println(stockTaskItem.toString());
            }
    }


}
