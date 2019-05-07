SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE VIEW [dbo].[AVA_IF_VIEW_USER]
AS
SELECT      USERID AS id, U_MobileUserId AS user_name, PASSWORD, isnull(U_IME,'N') AS is_mobile_user, U_MobilePassword AS mobile_password,
                   1 "companyId"
FROM         dbo.OUSR AS t0


GO

