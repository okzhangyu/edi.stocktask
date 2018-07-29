/****** Object:  Table [dbo].[USERAUTH]    Script Date: 2018/7/29 18:43:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[USERAUTH](
	[user_id] [varchar](50) NOT NULL,
	[auth_id] [varchar](50) NULL,
	[auth_type] [varchar](50) NULL,
	[auth_token] [varchar](50) NOT NULL,
	[auth_expires] [bigint] NULL,
	[is_active] [nchar](10) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


