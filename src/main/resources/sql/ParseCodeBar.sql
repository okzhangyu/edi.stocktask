create PROCEDURE ava_parse_codebar(
	@codebar nvarchar(300) --条码值
)
As

Begin
	-- 示例 返回参数都设置字符类型
	declare @itemCode nvarchar(50)
	declare @quantity nvarchar(50)
	select @itemCode = SUBSTRING(@codebar,0,8);
	select @quantity = convert(decimal,SUBSTRING(@codebar,9,12));

	--拼接结果 左边为字段名称（列名 ProName）  右边为值（列名ProValue） （该注释请勿删除）
	select 'ItemCode' as ProName ,@itemCode as ProValue
	union
	select 'Quantity',@quantity
End