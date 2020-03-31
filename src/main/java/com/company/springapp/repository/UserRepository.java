package com.company.springapp.repository;


import com.company.springapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    void saveUser(User user);

    Optional<User> getUser(long id);

    Optional<User> getByUsername(String username);

    void deleteUser(long id);

}
