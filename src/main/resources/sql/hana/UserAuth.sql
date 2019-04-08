/****** Object:  Table [dbo].[AVA_IF_USERAUTH]    Script Date: 2018/8/1 10:41:02 ******/
CREATE TABLE AVA_IF_USERAUTH(
	"user_id" varchar(50) NOT NULL,
	"auth_id" varchar(50) NULL,
	"auth_type" nvarchar(50) NULL,
	"auth_token" varchar(50) NOT NULL,
	"auth_expires" bigint NULL,
	"is_active" nchar(10) NULL
)
