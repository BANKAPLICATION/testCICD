package com.example.servletand.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T apply(ResultSet resultSet) throws SQLException;
}
