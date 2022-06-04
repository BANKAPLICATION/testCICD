package com.example.servletand.exception;

import java.sql.SQLException;

public class UserServiceException extends Throwable {

  public UserServiceException(String s, SQLException e) {}
}
