package org.edi.stocktask.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.edi.stocktask.dto.CodeBarParam;

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
        sourceDataTable.addColumnMetadata("BaseType" , Types.VARCHAR);
        sourceDataTable.addColumnMetadata("BaseEntry" ,Types.INTEGER);
        sourceDataTable.addColumnMetadata("BaseLine" , Types.INTEGER);
        sourceDataTable.addColumnMetadata("ItemCode" , Types.NVARCHAR);
        sourceDataTable.addColumnMetadata("Quantity" , Types.DOUBLE);
        List<CodeBarParam> dataList = (List)parameter;
        for (CodeBarParam item : dataList) {
             sourceDataTable.addRow(item.getCodeBar(),item.getBaseType(),item.getBaseEntry(),item.getBaseLine(),item.getItemCode(),item.getQuantity());
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
