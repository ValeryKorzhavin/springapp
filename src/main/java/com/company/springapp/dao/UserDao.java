package com.company.springapp.dao;

import com.company.springapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> findAll();

    void saveUser(User user);

    Optional<User> getUser(long id);

    void deleteUser(long id);

}
