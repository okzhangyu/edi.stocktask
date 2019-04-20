package util;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.edi.freamwork.cryptogram.MD5Util;
import org.edi.stocktask.bo.stockreport.StockReport;
import org.edi.stocktask.bo.stockreport.StockReportItem;
import org.edi.stocktask.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestUtil extends TestCase {

    @Test
    public void testListUtil(){
        List<String> paramList = new ArrayList<>();
        paramList.add("E");
        paramList.add("C");
        paramList.add("O");
        String paramRlt = ListUtil.getValues(paramList);
        Assert.assertEquals("'E','C','O'",paramRlt);
    }

    @Test
    public void testMD5()throws Exception{
        String password = "1234";
        String md5Password =MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(password.getBytes(),"avatech"));
        System.out.println("-------------------");
        System.out.println(md5Password);
    }
}
