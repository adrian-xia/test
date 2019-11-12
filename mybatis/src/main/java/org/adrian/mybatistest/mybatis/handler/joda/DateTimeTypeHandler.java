package org.adrian.mybatistest.mybatis.handler.joda;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by xialei on 2017/3/2.
 */
@MappedTypes(value = DateTime.class)
public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {

    private DateTime getDateTime(Timestamp ts) {
        if (ts != null) {
            return new DateTime(ts.getTime());
        } else {
            return null;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType) throws SQLException {
        //BaseTypeHandler做了parameter判空处理 我们直接拿来用
        ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnName);
        return getDateTime(ts);
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnIndex);
        return getDateTime(ts);
    }

    @Override
    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp ts = cs.getTimestamp(columnIndex);
        return getDateTime(ts);
    }
}
