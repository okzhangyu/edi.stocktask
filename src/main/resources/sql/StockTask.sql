/****** Object:  View [dbo].[AVA_WM_VIEW_OSTK]    Script Date: 2018/7/29 18:10:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

ALTER VIEW [dbo].[AVA_WM_VIEW_STK1]
AS
SELECT T0.* FROM
(
/*-------------------------生产订单---------------------------------*/
/*--生产订单成品 收货*/
      SELECT T0."DocEntry" "ObjectKey",1 "LineId",'R' AS "TransType",
              '202' AS "DocType",T0."DocEntry" AS "DocEntry",1 AS "DocLine",
              null "BaseType",null "BaseEntry",null "BaseLine",
              null "BSType",null "BSEntry",null "BSLine",
              T0."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              null "FromWH",null "FromLC",T0."Warehouse" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              (T0."PlannedQty" - ISNULL(T0."CmpltQty",0)) "Quantity", (T0."PlannedQty" - ISNULL(T0."CmpltQty",0)) - isnull(T3."Quantity",0) "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OWOR" T0 LEFT JOIN SBODemoCN.dbo."OITM" T2 ON T0."ItemCode" = T2."ItemCode"
		  left join AVA_WM_SRP1 t3 on t0.DocEntry = t3.BaseEntry and  '202' = t3.BaseType and 1 = t3.BaseLine
          WHERE T0."Status" = 'R' AND ISNULL(T0."U_Sanctified",'R') = 'R'
                AND (T0."PlannedQty" - ISNULL(T0."CmpltQty",0)) > 0
/*生产订单 原材料发货*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'I' AS "TransType",
              '202' AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              null "BaseType",null "BaseEntry",null "BaseLine",
              null "BSType",null "BSEntry",null "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              null "FromWH",null "FromLC",T1."wareHouse" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."PlannedQty",0)  "Quantity", ISNULL(T1."PlannedQty",0) - isnull(T3."Quantity",0) "OpenQuantity",
			   case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OWOR" T0 INNER JOIN SBODemoCN.dbo."WOR1" T1 ON T0."DocEntry" = T1."DocEntry" AND T1."IssueType" = 'M'
                INNER JOIN SBODemoCN.dbo.OITM T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  '202' = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."Status" = 'R' AND ISNULL(T0."U_Sanctified",'R') = 'R'
                AND ISNULL(T1."PlannedQty",0)  > 0
/*-------------------------采购订单---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'R' AS "TransType",
              T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              null "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",ISNULL(T1."Quantity",0) - isnull(T3."Quantity",0) "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OPOR" T0 INNER JOIN SBODemoCN.dbo."POR1" T1 ON T0."DocEntry" = T1."DocEntry"
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0

/*-------------------------库存转储申请---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'T' AS "TransType",
              T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0)  "Quantity",ISNULL(T1."Quantity",0) - isnull(T3."Quantity",0) "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OWTQ" T0 INNER JOIN SBODemoCN.dbo."WTQ1" T1 ON T0."DocEntry" = T1."DocEntry"
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------销售订单---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'I' AS "TransType",
              T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",ISNULL(T1."Quantity",0) - isnull(T3."Quantity",0) "OpenQuantity",
			   case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ORDR" T0 INNER JOIN SBODemoCN.dbo."RDR1" T1 ON T0."DocEntry" = T1."DocEntry"
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------销售退货（草稿）---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'R' AS "TransType",
              '112-' + T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",ISNULL(T1."Quantity",0) - isnull(T3."Quantity",0) "OpenQuantity",
			   case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ODRF" T0 INNER JOIN SBODemoCN.dbo."DRF1" T1 ON T0."DocEntry" = T1."DocEntry" AND T0."ObjType" = '16'
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and '112-' + T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------销售交货（草稿）---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'I' AS "TransType",
              '112-' + T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0)  "Quantity",ISNULL(T1."Quantity",0) - isnull(T3."Quantity",0) "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ODRF" T0 INNER JOIN SBODemoCN.dbo."DRF1" T1 ON T0."DocEntry" = T1."DocEntry" AND T0."ObjType" = '15'
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and '112-' + T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------采购收货（草稿）---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'R' AS "TransType",
              '112-' + T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",ISNULL(T1."Quantity",0) - isnull(T3."Quantity",0) "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ODRF" T0 INNER JOIN SBODemoCN.dbo."DRF1" T1 ON T0."DocEntry" = T1."DocEntry" AND T0."ObjType" = '20'
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and '112-' + T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
) T0 left join SBODemoCN.dbo.OITM T1 on T0."ItemCode"=T1."ItemCode"
GO

/******************************************************************************************/


/****** Object:  View [dbo].[AVA_WM_VIEW_STK1]    Script Date: 2018/7/30 16:22:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



ALTER VIEW [dbo].[AVA_WM_VIEW_STK1]
AS
SELECT T0.* FROM
(
/*-------------------------生产订单---------------------------------*/
/*--生产订单成品 收货*/
      SELECT T0."DocEntry" "ObjectKey",1 "LineId",'R' AS "TransType",
              '202' AS "DocType",T0."DocEntry" AS "DocEntry",1 AS "DocLine",
              null "BaseType",null "BaseEntry",null "BaseLine",
              null "BSType",null "BSEntry",null "BSLine",
              T0."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              null "FromWH",null "FromLC",T0."Warehouse" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              (T0."PlannedQty" - ISNULL(T0."CmpltQty",0)) "Quantity", (T0."PlannedQty" - ISNULL(T0."CmpltQty",0)) - t3."Quantity" "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OWOR" T0 LEFT JOIN SBODemoCN.dbo."OITM" T2 ON T0."ItemCode" = T2."ItemCode"
		  left join AVA_WM_SRP1 t3 on t0.DocEntry = t3.BaseEntry and  '202' = t3.BaseType and 1 = t3.BaseLine
          WHERE T0."Status" = 'R' AND ISNULL(T0."U_Sanctified",'R') = 'R'
                AND (T0."PlannedQty" - ISNULL(T0."CmpltQty",0)) > 0
/*生产订单 原材料发货*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'I' AS "TransType",
              '202' AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              null "BaseType",null "BaseEntry",null "BaseLine",
              null "BSType",null "BSEntry",null "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              null "FromWH",null "FromLC",T1."wareHouse" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."PlannedQty",0)  "Quantity",t1."PlannedQty" - t3."Quantity" "OpenQuantity",
			   case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OWOR" T0 INNER JOIN SBODemoCN.dbo."WOR1" T1 ON T0."DocEntry" = T1."DocEntry" AND T1."IssueType" = 'M'
                INNER JOIN SBODemoCN.dbo.OITM T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  '202' = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."Status" = 'R' AND ISNULL(T0."U_Sanctified",'R') = 'R'
                AND ISNULL(T1."PlannedQty",0)  > 0
/*-------------------------采购订单---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'R' AS "TransType",
              T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              null "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",t1."Quantity" - t3."Quantity" "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OPOR" T0 INNER JOIN SBODemoCN.dbo."POR1" T1 ON T0."DocEntry" = T1."DocEntry"
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0

/*-------------------------库存转储申请---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'T' AS "TransType",
              T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0)  "Quantity",t1."Quantity" - t3."Quantity" "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."OWTQ" T0 INNER JOIN SBODemoCN.dbo."WTQ1" T1 ON T0."DocEntry" = T1."DocEntry"
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------销售订单---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'I' AS "TransType",
              T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",t1."Quantity" - t3."Quantity" "OpenQuantity",
			   case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ORDR" T0 INNER JOIN SBODemoCN.dbo."RDR1" T1 ON T0."DocEntry" = T1."DocEntry"
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and  T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------销售退货（草稿）---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'R' AS "TransType",
              '112-' + T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",t1."Quantity" - t3."Quantity" "OpenQuantity",
			   case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ODRF" T0 INNER JOIN SBODemoCN.dbo."DRF1" T1 ON T0."DocEntry" = T1."DocEntry" AND T0."ObjType" = '16'
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and '112-' + T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------销售交货（草稿）---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'I' AS "TransType",
              '112-' + T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0)  "Quantity",t1."Quantity" - t3."Quantity" "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ODRF" T0 INNER JOIN SBODemoCN.dbo."DRF1" T1 ON T0."DocEntry" = T1."DocEntry" AND T0."ObjType" = '15'
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and '112-' + T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
/*-------------------------采购收货（草稿）---------------------------------*/
          UNION ALL
          SELECT T0."DocEntry" "ObjectKey",T1."LineNum" "LineId",'R' AS "TransType",
              '112-' + T0."ObjType" AS "DocType",T0."DocEntry" AS "DocEntry",T1."LineNum" AS "DocLine",
              T1."BaseType" "BaseType",T1."BaseEntry" "BaseEntry",T1."BaseLine" "BaseLine",
              NULL "BSType",NULL "BSEntry",NULL "BSLine",
              T1."ItemCode",T2."ItemName",T2."ManBtchNum",T2."ManSerNum",T2."InvntryUom",'1' "ScanType",
              0.0 "Price",'RMB' "Currency",0.0 "Rate",0.0 "LineTotal",
              T1."FromWhsCod" "FromWH",null "FromLC",T1."WhsCode" "ToWH",null "ToLC",
              NULL AS "Ref1",NULL AS "Ref2",
              ISNULL(T1."Quantity",0) "Quantity",t1."Quantity" - t3."Quantity" "OpenQuantity",
			  case when T3."Docentry" is null then 'O' else 'C' end as "LineStatus"
          FROM SBODemoCN.dbo."ODRF" T0 INNER JOIN SBODemoCN.dbo."DRF1" T1 ON T0."DocEntry" = T1."DocEntry" AND T0."ObjType" = '20'
                INNER JOIN SBODemoCN.dbo."OITM" T2 ON T1."ItemCode" = T2."ItemCode"
				left join AVA_WM_SRP1 t3 on t1.DocEntry = t3.BaseEntry and '112-' + T0."ObjType" = t3.BaseType and t1.LineNum = t3.BaseLine
          WHERE T0."DocStatus" = 'O' AND T0."CANCELED" <> 'Y' AND ISNULL(T0."U_Sanctified",'R') = 'R' AND T1."LineStatus" = 'O'
                 AND ISNULL(T1."Quantity",0) > 0
) T0 left join SBODemoCN.dbo.OITM T1 on T0."ItemCode"=T1."ItemCode"

GO











