package org.edi.stocktask.repository;

import org.edi.stocktask.bo.codeBar.CodeBar;
import org.edi.stocktask.mapper.CodeBarMapper;
import org.edi.stocktask.mapper.StockReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/10
 */
@Component(value="boReposirotyCodeBar")
public class BORepositoryCodeBar implements IBORepositoryCodeBar{

    @Autowired
    private CodeBarMapper codeBarMapper;


    @Override
    public List<CodeBar> parseCodeBar(String codeBar) {

        return codeBarMapper.paseCodeBar(codeBar);
    }
}
