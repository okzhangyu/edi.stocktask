package org.edi.stocktask.data;

import org.edi.freamwork.data.operation.OpResultDescription;

/**
 * @author Fancy
 * @date 2018/7/30
 */
public class StockOpResultDescription extends OpResultDescription {

    public static final String STOCK_DATABASE_ERROR ="数据库操作错误";
    public static final String STOCKTASK_IS_EMPTY = "the stocktask is null";

    public static final String STOCKTASK_IS_CLOSE = "单据已清，不能操作该单据";

    public static final String DOCENTRY_IS_EMPTY = "单据号为空";

    public static final String STOCK_OBJECT_DETAIL_IS_EMPTY = "汇报明细为空";

    public static final String STOCK_OBJECT_BASETYPE_IS_NULL = "字段[baseDocumentType]为空";

    public static final String STOCK_OBJECT_DOCSTATUS_IS_NULL = "字段[documentStatus]为空";

    public static final String STOCK_OBJECT_LINESTATUS_IS_NULL = "字段[lineStatus]为空";

    public static final String STOCK_OBJECT_OBJECTCODE_IS_NULL = "业务对象类型为空";

    public static final String STOCK_OBJECT_ITEMCODE_IS_NULL = "字段[itemCode]为空";

    public static final String STOCK_OBJECT_BASEENTRY_IS_INVALID = "字段[baseDocumentEntry]无效";

    public static final String STOCK_OBJECT_BASELINE_IS_NULL = "字段[baseDocumentLineId]为空";

    public static final String STOCK_OBJECT_QUANTITY_IS_INVALID = "字段[quantity]无效";

    public static final String STOCK_OBJECT_TOWAREHOUSE_IS_NULL = "字段[toWareHouse]为空";

    public static final String STOCK_CODEBAR_IS_EMPTY = "条码信息为空";

    public static final String B1DOCENTRY_IS_EXISTENT = "单据已生成";

    public static final String PARAMETER_IS_NULL= "参数信息为空";

    public static final String CODEBAR_IS_NULL= "条码信息为空";

    public static final String DOCTYPE_IS_NULL= "[DOCTYPE]信息为空";

    public static final String DETAIL_IS_NULL= "汇报明细为空";

    public static final String REPORTTASK_IS_EMPTY= "未找到汇报库存任务";

    public static final String REPORT_IS_EMPTY= "未找到库存汇报";

    public static final String TASK_IS_EMPTY= "未找到库存任务";

    public static final String MATERIALITEM_IS_NULL= "物料条码信息为空";

    public static final String CODEBAR_IS_REPEAT= "汇报行条码信息不可重复";

    public static final String STOCK_BASETYPE_IS_NULL = "[baseType]信息为空";

    public static final String STOCK_BASEENTRY_IS_NULL = "[baseEntry]信息为空";

    public static final String STOCK_BASELINE_IS_NULL = "[baseLine]信息为空";

    public static final String CODEBARINFO_IS_EMPTY = "条形码与对应任务行的物料不匹配";

    public static final String BARCODE_ANALYSIS_IS_FAIL = "条码[%s]解析失败";

    public static final String BARCODE_ANALYSIS_EXCEPTION = "条码解析异常，请联系管理员";

    public static final String BARCODE_PARSE_RESULT_IS_ERROR = "条码解析结果错误，无法找到任务行信息";

    public static final String STOCK_OBJECT_TargetDocumentType_IS_NULL = "目标单据类型为空";

}
