package org.edi.stocktask.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.edi.stocktask.dto.ItemCodeQuantity;

import java.sql.*;
import java.util.List;

/**
 * Created by asus on 2018/9/6.
 */


@MappedJdbcTypes(JdbcType.ARRAY)
public class ItemCodeQuantityHandler extends BaseTypeHandler<Object> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        SQLServerDataTable sourceDataTable = new SQLServerDataTable();
        sourceDataTable.addColumnMetadata("ItemCode" , Types.NVARCHAR);
        sourceDataTable.addColumnMetadata("Quantity" , Types.DOUBLE);
        List<ItemCodeQuantity> dataList = (List)parameter;
        for (ItemCodeQuantity item : dataList) {
            sourceDataTable.addRow(item.getItemCode(),item.getQuantity());
        }
        ps.setObject(i, sourceDataTable);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {

        return null;
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

}
