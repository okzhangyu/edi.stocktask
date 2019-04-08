USE [StockManageDB]
GO

/****** Object:  StoredProcedure [dbo].[AVA_SP_PARSE_CODEBAR]    Script Date: 2018/8/15 15:12:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[AVA_SP_PARSE_CODEBAR](
	@codebar nvarchar(300), --条码值
	@basetype nvarchar(300), --基于类型
	@baseentry int, --基于单号
	@baseline int --基于行号
)
As

	Begin
		-- 示例
		declare @itemCode nvarchar(50)
		declare @quantity nvarchar
		select @itemCode = SUBSTRING(@codebar,0,8);
		select @quantity = SUBSTRING(@codebar,9,12);

		--拼接结果 左边为字段名称  右边为值 返回类型注意都返回字符类型（该注释请勿删除）
		select 'ItemCode' as ProName ,'物料编码' as ProDesc , @itemCode as ProValue
		union
		select 'ItemDesc','物料名称','联想G50'
		union
		select 'Quantity','数量',@quantity
		union
		select 'Price','价格','19999.99'
	End
GO


