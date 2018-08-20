package org.edi.stocktask.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.edi.stocktask.dto.CodeBarParam;
import org.edi.stocktask.dto.CodeBarParseParam;

import java.sql.*;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/8/20
 */
@MappedJdbcTypes(JdbcType.ARRAY)
public class TableTypeHandler extends BaseTypeHandler<Object> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        SQLServerDataTable sourceDataTable = new SQLServerDataTable();
        sourceDataTable.addColumnMetadata("CodeBar" , Types.NVARCHAR);
        sourceDataTable.addColumnMetadata("BaseLine" , Types.INTEGER);
        sourceDataTable.addColumnMetadata("ItemCode" , Types.NVARCHAR);
        sourceDataTable.addColumnMetadata("Quantity" , Types.DOUBLE);
        sourceDataTable.addColumnMetadata("CodeBarQty" , Types.DOUBLE);
        List<CodeBarParseParam> dataList = (List)parameter;
        for (CodeBarParseParam item : dataList) {
             sourceDataTable.addRow(item.getCodeBar(),item.getBaseLine(),item.getItemCode(),item.getQuantity(),item.getCodeBarQty());
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
