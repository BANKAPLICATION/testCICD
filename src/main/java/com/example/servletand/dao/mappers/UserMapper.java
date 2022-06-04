package com.example.servletand.dao.mappers;

import com.example.servletand.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.servletand.model.*;


public class UserMapper implements Mapper<User> {

  @Override
  public User apply(ResultSet resultSet) throws SQLException {
    return new User(resultSet.getLong(User.USER_ID), resultSet.getString(User.USER_NAME), resultSet.getString(User.USER_SURNAME), resultSet.getInt(User.USER_AGE));
  }
}
