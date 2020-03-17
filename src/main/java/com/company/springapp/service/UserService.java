package com.company.springapp.service;

import com.company.springapp.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User getUser(Long id);

    void saveUser(User user);

    void deleteUser(Long id);

}
