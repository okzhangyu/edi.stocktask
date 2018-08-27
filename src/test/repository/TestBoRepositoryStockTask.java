package repository;

import junit.framework.TestCase;
import org.edi.freamwork.log.LogFileName;
import org.edi.freamwork.log.LoggerUtils;
import org.edi.stocktask.data.StockTaskData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBoRepositoryStockTask extends TestCase {
    Logger logger = LoggerUtils.Logger(StockTaskData.APPENDER_NAME);

    @Test
    public void testLog(){
        logger.info("stock test log");

        Logger avaLogger = LoggerUtils.Logger(LogFileName.AVA);
        Logger edfLogger = LoggerUtils.Logger("edf");
        Logger ysyjLogger = LoggerUtils.Logger("ysyj");
        //Logger logger = LoggerFactory.getLogger(TestBoRepositoryStockTask.class);
        logger.info("this is info");
        logger.warn("this is ware");
        logger.error("this is bug");
        logger.debug("this is debug");
        avaLogger.info("AVA's log %1","232323");
        avaLogger.error("AVA's error log");
        edfLogger.info("EDF's log");
        //edfLogger.info(new  Exception("this is eeror"));
        edfLogger.error("EDF's error");
        ysyjLogger.info("YSYJ's info");
        ysyjLogger.error("YSYJ's error");
    }
}
