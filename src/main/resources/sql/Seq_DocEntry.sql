USE [StockManageDB]
GO

USE [StockManageDB]
GO

/****** Object:  Sequence [dbo].[Seq_DocEntry]    Script Date: 2018/7/30 10:23:27 ******/
CREATE SEQUENCE [dbo].[Seq_DocEntry]
 AS [bigint]
 START WITH 200
 INCREMENT BY 1
 MINVALUE 100
 MAXVALUE 2000
 CYCLE
 CACHE  3
GO

