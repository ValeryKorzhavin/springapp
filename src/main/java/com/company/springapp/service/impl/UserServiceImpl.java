package com.company.springapp.service.impl;

import com.company.springapp.domain.User;
import com.company.springapp.repository.UserRepository;
import com.company.springapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

}
