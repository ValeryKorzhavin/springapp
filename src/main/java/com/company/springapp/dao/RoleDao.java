package com.company.springapp.dao;

import com.company.springapp.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {

    List<Role> findAll();

    Optional<Role> getRole(long id);

    void saveRole(Role role);

    void deleteRole(long id);

}
