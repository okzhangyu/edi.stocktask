/****** Object:  StoredProcedure [dbo].[ava_parse_codebar]    Script Date: 2018/7/31 10:31:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[ava_parse_codebar](
	@codebar nvarchar(300) --条码值
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