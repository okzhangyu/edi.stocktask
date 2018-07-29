SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE VIEW [dbo].[VIEW_IUSER]
AS
SELECT      USERID AS id, U_NAME AS user_name, PASSWORD, U_MobileUserId AS is_mobile_user, U_MobilePassword AS mobile_password,
                   companyId
FROM         SBODemoCN.dbo.OUSR AS t0


GO