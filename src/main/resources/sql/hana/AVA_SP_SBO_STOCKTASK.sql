


create  PROC [dbo].[AVA_SP_SBO_STOCKTASK]
    @object_type NVARCHAR(20) , 				-- SBO Object Type
    @transaction_type NCHAR(1),					-- [A]dd, [U]pdate, [D]elete, [C]ancel, C[L]ose
    @num_of_cols_in_key INT,
    @list_of_key_cols_tab_del NVARCHAR(255),
    @list_of_cols_val_tab_del NVARCHAR(255)
AS
BEGIN
	DECLARE @WM_DocEntry int;
	set @WM_DocEntry = 0;
	IF @transaction_type = 'A' --只处理单据生成添加
	BEGIN
		--销售交货
		IF @object_type = '15'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from ODLN where DocEntry = @list_of_cols_val_tab_del
		END

		--销售退货
		IF @object_type = '16'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from ORDN where DocEntry = @list_of_cols_val_tab_del
		END

		--采购收获

		IF @object_type = '20'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from OPDN where DocEntry = @list_of_cols_val_tab_del
		END

		--采购退货
		IF @object_type = '21'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from ORPD where DocEntry = @list_of_cols_val_tab_del
		END
		--收获
		IF @object_type = '59'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from OIGN where DocEntry = @list_of_cols_val_tab_del
		END

		--发货
		IF @object_type = '60'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from OIGE where DocEntry = @list_of_cols_val_tab_del
		END

		--库存转储
		IF @object_type = '67'
		BEGIN
			select @WM_DocEntry = U_WM_DocEntry from OWTR where DocEntry = @list_of_cols_val_tab_del
		END

		IF @WM_DocEntry > 0
		BEGIN
			Update AVA_WM_OSRP set DocStatus = 'C',B1DocEntry = @list_of_cols_val_tab_del where DocEntry = @WM_DocEntry;
			Update AVA_WM_SRP1 set LineStatus = 'C' where DocEntry = @WM_DocEntry;
		END
	END
END