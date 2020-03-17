package com.company.springapp.dao;

import com.company.springapp.domain.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    Role getRole(Long id);

    void saveRole(Role role);

    void deleteRole(Long id);

}
