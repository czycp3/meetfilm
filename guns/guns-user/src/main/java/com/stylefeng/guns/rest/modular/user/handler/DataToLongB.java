package com.stylefeng.guns.rest.modular.user.handler;

import com.stylefeng.guns.rest.modular.cinema.bean.Data;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther 芮狼Dan
 * @date 2019-06-07 11:54
 */
public class DataToLongB extends BaseTypeHandler<Long> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Long aLong, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Long getNullableResult(ResultSet resultSet, String begin_time) throws SQLException {
        String stringData = resultSet.getString("begin_time");
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long longDate = null;

        try {
            Date dateDate = fmt.parse(stringData);
            longDate=dateDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return longDate;
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String stringData = resultSet.getString(i);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long longDate = null;

        try {
            Date dateDate = fmt.parse(stringData);
            longDate=dateDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return longDate;
    }

    @Override
    public Long getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String stringData = callableStatement.getString(i);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long longDate = null;

        try {
            Date dateDate = fmt.parse(stringData);
            longDate=dateDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return longDate;
    }
}
