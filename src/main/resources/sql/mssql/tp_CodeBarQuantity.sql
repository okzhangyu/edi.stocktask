CREATE TYPE [dbo].[tp_CodeBarQuantity] AS TABLE(
	[ItemCode] [nvarchar](30) NULL,
	[Quantity] [decimal](22, 6) NULL,
	[BarCode] [nvarchar](100) NULL
)
GO