/****** Object:  Table [dbo].[AVA_IF_USERAUTH]    Script Date: 2018/8/1 10:41:02 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[AVA_IF_USERAUTH](
	[user_id] [varchar](50) NOT NULL,
	[auth_id] [varchar](50) NULL,
	[auth_type] [nvarchar](50) NULL,
	[auth_token] [varchar](50) NOT NULL,
	[auth_expires] [bigint] NULL,
	[is_active] [nchar](10) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO