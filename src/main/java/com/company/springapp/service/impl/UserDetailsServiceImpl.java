package com.company.springapp.service.impl;

import com.company.springapp.controller.exception.UserNotFoundException;
import com.company.springapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.company.springapp.domain.User user = userService
            .findUserByUsername(username)
            .orElseThrow(() -> new UserNotFoundException(username));

        return User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }

}
