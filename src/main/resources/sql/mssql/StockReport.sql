
/****** Object:  Table [dbo].[AVA_WM_OSRP]    Script Date: 2018/7/29 18:37:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AVA_WM_OSRP](
	[CompanyName] [nvarchar](20) NULL,
	[DocEntry] [int] NOT NULL,
	[DocNum] [int] NULL,
	[Period] [int] NULL,
	[Object] [varchar](30) NULL,
	[Transfered] [nvarchar](1) NULL,
	[CreateDate] [datetime] NULL,
	[CreateTime] [smallint] NULL,
	[UpdateDate] [datetime] NULL,
	[UpdateTime] [smallint] NULL,
	[Creator] [int] NULL,
	[Updator] [int] NULL,
	[DocStatus] [varchar](1) NULL,
	[DocDate] [datetime] NULL,
	[DocDueDate] [datetime] NULL,
	[TaxDate] [datetime] NULL,
	[Ref1] [nvarchar](100) NULL,
	[Ref2] [nvarchar](200) NULL,
	[Remarks] [nvarchar](200) NULL,
	[B1DocEntry] [int] NULL,
	[BydUUID] [nvarchar](36) NULL,
	[CusType] [nvarchar](8) NULL,
	[TransType] [varchar](1) NULL,
	[BpCode] [nvarchar](20) NULL,
	[BpName] [nvarchar](100) NULL,
	[BaseType] [nvarchar](30) NULL,
	[BaseEntry] [int] NULL,
 CONSTRAINT [KAVA_WM_OSRP] PRIMARY KEY CLUSTERED
(
	[DocEntry] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


/******************************************************************************************/

/****** Object:  Table [dbo].[AVA_WM_SRP1]    Script Date: 2018/7/29 18:38:02 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AVA_WM_SRP1](
	[DocEntry] [int] NOT NULL,
	[LineId] [int] NOT NULL,
	[Object] [varchar](30) NULL,
	[LineStatus] [varchar](1) NULL,
	[Ref1] [nvarchar](100) NULL,
	[Ref2] [nvarchar](200) NULL,
	[BaseType] [nvarchar](30) NULL,
	[BaseEntry] [int] NULL,
	[BaseLine] [int] NULL,
	[Project] [nvarchar](8) NULL,
	[OcrCode1] [nvarchar](8) NULL,
	[OcrCode2] [nvarchar](8) NULL,
	[OcrCode3] [nvarchar](8) NULL,
	[OcrCode4] [nvarchar](8) NULL,
	[OcrCode5] [nvarchar](8) NULL,
	[BSType] [nvarchar](30) NULL,
	[BSEntry] [int] NULL,
	[BSLine] [int] NULL,
	[TargetType] [nvarchar](30) NULL,
	[TargetEntry] [int] NULL,
	[TargetLine] [int] NULL,
	[ItemCode] [nvarchar](20) NULL,
	[ItemName] [nvarchar](200) NULL,
	[Quantity] [numeric](19, 6) NULL,
	[Uom] [nvarchar](8) NULL,
	[ManSerNum] [nvarchar](1) NULL,
	[ManBtchNum] [nvarchar](1) NULL,
	[ManServiceNum] [nvarchar](1) NULL,
	[Price] [numeric](19, 6) NULL,
	[Currency] [nvarchar](8) NULL,
	[Rate] [numeric](19, 6) NULL,
	[LineTotal] [numeric](19, 6) NULL,
	[FromWH] [nvarchar](8) NULL,
	[FromLC] [nvarchar](60) NULL,
	[ToWH] [nvarchar](8) NULL,
	[ToLC] [nvarchar](60) NULL,
	[BatchNum] [nvarchar](30) NULL,
	[SerialNum] [nvarchar](30) NULL,
	[BarCode1] [nvarchar](60) NULL,
	[BarCode2] [nvarchar](60) NULL,
	[BarCode3] [nvarchar](60) NULL,
	[BarCode4] [nvarchar](60) NULL,
 CONSTRAINT [KAVA_WM_SRP1] PRIMARY KEY CLUSTERED
(
	[DocEntry] ASC,
	[LineId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/******************************************************************************************/

/****** Object:  Table [dbo].[AVA_WM_SRP2]    Script Date: 2018/8/6 19:40:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AVA_WM_SRP2](
	[DocEntry] [int] NOT NULL,
	[LineId] [int] NOT NULL,
	[Object] [nvarchar](50) NULL,
	[ItemCode] [nvarchar](50) NULL,
	[BarCode] [nvarchar](50) NOT NULL,
	[BatchNumber] [nvarchar](50) NULL,
	[SerialNumber] [nvarchar](50) NULL,
	[Quantity] [numeric](19, 6) NULL,
 CONSTRAINT [PK_AVA_WM_SRP2] PRIMARY KEY CLUSTERED
(
	[DocEntry] ASC,
	[LineId] ASC,
	[BarCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

