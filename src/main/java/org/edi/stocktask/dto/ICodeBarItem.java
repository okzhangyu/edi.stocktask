package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/20
 * 条码明细 批量解析传入参数
 */
public interface ICodeBarItem {

    String getItemCode();

    void setItemCode(String itemCode);

    Integer getBaseLine();

    void setBaseLine(Integer baseLine);

    String getBarCode();

    void setBarCode(String barCode);

    Double getQuantity();

    void setQuantity(Double quantity);

    Double getQtyPlan();

    void setQtyPlan(Double qtyPlan);

    String getRemark();

    void setRemark(String remark);
}
