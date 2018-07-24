package org.edi.stocktask.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.stocktask.bo.codeBar.CodeBar;
import org.edi.stocktask.mapper.CodeBarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
@Component(value="boRepositoryCodeBar")
public class BORepositoryCodeBar implements IBORepositoryCodeBar{

    @Autowired
    private CodeBarMapper codeBarMapper;


    @Override
    public List<CodeBar> parseCodeBar(String codebar) {
        if(codebar==null||codebar.equals("")){
            throw  new BusinessException(ResultDescription.CODEBAR_IS_NULL);
        }
        List<CodeBar> listCodeBar = new ArrayList<>();
        HashMap<String,String> codeBar = new HashMap();
        codeBar.put("codebar",codebar);
        codeBarMapper.parseCodeBar(codeBar);
        listCodeBar = codeBarMapper.parseCodeBar(codeBar);
        return listCodeBar;
    }
}
