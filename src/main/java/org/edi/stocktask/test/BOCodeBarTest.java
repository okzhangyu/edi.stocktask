package org.edi.stocktask.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.stocktask.bo.codeBar.CodeBar;
import org.edi.stocktask.mapper.CodeBarMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 2018/7/25.
 * 条码解析单元测试
 */
public class BOCodeBarTest {



    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        return openSession;
    }

    public CodeBarMapper getCodeBarMapper() throws IOException {
        CodeBarMapper codeBarMapper=getSqlSession().getMapper(CodeBarMapper.class);
        return codeBarMapper;
    }

    /**
     * 条码解析
     * @param codebar
     * @return
     */
    public List<CodeBar> parseCodeBar(String codebar)throws IOException{
        if(codebar==null||codebar.equals("")){
            throw  new BusinessException(ResultDescription.CODEBAR_IS_NULL);
        }
        List<CodeBar> listCodeBar = new ArrayList<>();
        HashMap<String,String> codeBar = new HashMap();
        codeBar.put("codebar",codebar);
        getCodeBarMapper().parseCodeBar(codeBar);
        listCodeBar = getCodeBarMapper().parseCodeBar(codeBar);
        return listCodeBar;
    }


    @Test
    public void parseCodeBarTest()throws IOException{
        List<CodeBar> listCodeBar = new ArrayList<>();
        listCodeBar = parseCodeBar("1789635296397");
       for (CodeBar codeBar1:listCodeBar){
           System.out.println(codeBar1.toString());
       }
    }
}
