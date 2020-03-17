package com.company.springapp.dao;

import com.company.springapp.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

}
