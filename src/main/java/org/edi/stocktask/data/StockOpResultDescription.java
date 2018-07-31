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
}
