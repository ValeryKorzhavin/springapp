package com.company.springapp.service;

import com.company.springapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> getUser(long id);

    void saveUser(User user);

    void deleteUser(long id);

}
