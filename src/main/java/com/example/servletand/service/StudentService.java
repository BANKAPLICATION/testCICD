package com.example.servletand.service;

import com.example.servletand.dao.datasource.Datasource;
import com.example.servletand.dao.impl.UserDaoImpl;
import lombok.RequiredArgsConstructor;
import com.example.servletand.model.*;
import com.example.servletand.dao.*;
import com.example.servletand.exception.*;


import java.sql.SQLException;
import java.util.List;


@RequiredArgsConstructor
public class StudentService {

  private final UserDaoImpl userDao;
  private final Datasource datasource;

  public User save(User user) throws UserServiceException {
    User savedUser;
    try {
      savedUser = userDao.save(datasource.getConnection(), user);
    } catch (SQLException e) {
      throw new UserServiceException("User wasn't save", e);
    }
    return savedUser;
  }

  public void delete(Long id) throws UserServiceException {
    try {
      userDao.deleteById(datasource.getConnection(), id);
    } catch (SQLException e) {
      throw new UserServiceException("User wasn't delete", e);
    }
  }

  public User find(Long id) {
    try {
      return userDao.findById(datasource.getConnection(), id)
          .get();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<User> findAll() {
    try {
      return userDao.findAll(datasource.getConnection());
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

}
