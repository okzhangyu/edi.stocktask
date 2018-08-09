package org.edi.stocktask.data;

import org.edi.freamwork.data.operation.OpResultCode;

/**
 * @author Fancy
 * @date 2018/7/31
 */
public class StockOpResultCode extends OpResultCode{

    /**
     * 对象为空
     */

    public static final String STOCK_OBJECT_DATABASE_ERROR = "3202000";

    public static final String STOCK_OBJECT_BASETYPE_IS_NULL = "6102002";

    public static final String STOCK_OBJECT_BASEENTRY_IS_NULL = "6102003";

    public static final String STOCK_OBJECT_BASELINEID_IS_NULL = "6102004";

    public static final String STOCK_OBJECT_DOCSTATUS_IS_NULL = "6102005";

    public static final String STOCK_OBJECT_LINESTATUS_IS_NULL = "6102006";

    public static final String STOCK_OBJECT_OBJECTCODE_IS_NULL = "6102007";

    public static final String STOCK_CODEBAR_IS_NULL = "6102101";

    public static final String STOCK_OBJECT_ITEMCODE_IS_NULL = "6102102";

    public static final String STOCK_OBJECT_BASEENTRY_IS_INVALID = "6102103";

    public static final String STOCK_OBJECT_BASELINE_IS_INVALID = "6102104";

    public static final String STOCK_OBJECT_QUANTITY_IS_INVALID = "6102105";

}
