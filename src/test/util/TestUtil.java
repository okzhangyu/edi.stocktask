package util;

import junit.framework.Assert;
import junit.framework.TestCase;
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
}
