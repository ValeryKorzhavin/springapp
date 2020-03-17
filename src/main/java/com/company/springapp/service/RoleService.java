package com.company.springapp.service;

import com.company.springapp.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role getRole(Long id);

    void saveRole(Role role);

    void deleteRole(Long id);

}
