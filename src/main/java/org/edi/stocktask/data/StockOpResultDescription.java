package org.edi.stocktask.data;

import org.edi.freamwork.data.operation.OpResultDescription;

/**
 * @author Fancy
 * @date 2018/7/30
 */
public class StockOpResultDescription extends OpResultDescription {

    public static final String STOCKTASK_IS_EMPTY = "the stocktask is null";

    public static final String STOCKTASK_IS_CLOSE = "单据已清，不能操作该单据";

    public static final String DOCENTRY_IS_EMPTY = "单据号为空";

    public static final String STOCK_OBJECT_BASETYPE_IS_NULL = "字段[baseDocumentType]为空";

    public static final String STOCK_OBJECT_DOCSTATUS_IS_NULL = "字段[documentStatus]为空";

    public static final String STOCK_OBJECT_LINESTATUS_IS_NULL = "字段[lineStatus]为空";

    public static final String STOCK_OBJECT_OBJECTCODE_IS_NULL = "业务对象类型为空";

    public static final String STOCK_OBJECT_ITEMCODE_IS_NULL = "字段[itemCode]为空";

    public static final String STOCK_OBJECT_BASEENTRY_IS_INVALID = "字段[baseDocumentEntry]无效";

    public static final String STOCK_OBJECT_BASELINE_IS_NULL = "字段[baseDocumentLineId]为空";

    public static final String STOCK_OBJECT_QUANTITY_IS_INVALID = "字段[quantity]无效";

    public static final String STOCK_OBJECT_TOWAREHOUSE_IS_NULL = "字段[toWareHouse]为空";

}
