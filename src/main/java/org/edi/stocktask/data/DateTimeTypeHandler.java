package org.edi.stocktask.data;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.edi.freamwork.data.DateTime;

import java.sql.*;
import java.util.Date;

/**
 * @author Fancy
 * @date 2018/7/26
 */
public class DateTimeTypeHandler implements TypeHandler<DateTime> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        if(dateTime == null) {
            preparedStatement.setDate(i, null);
        } else {
            preparedStatement.setTime(i, Time.valueOf(dateTime.toString()) );
        }
    }

    @Override
    public DateTime getResult(ResultSet resultSet, String s) throws SQLException {
        Date date = resultSet.getDate(s);
        return date == null?null:DateTime.valueOf(date);
    }

    @Override
    public DateTime getResult(ResultSet resultSet, int i) throws SQLException {
        Date date = resultSet.getDate(i);
        return date == null?null:DateTime.valueOf(date);
    }

    @Override
    public DateTime getResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = callableStatement.getDate(i);
        return date == null?null:DateTime.valueOf(date);
    }
}
