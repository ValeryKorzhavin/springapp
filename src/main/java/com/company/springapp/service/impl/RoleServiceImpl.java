package com.company.springapp.service.impl;

import com.company.springapp.dao.RoleDao;
import com.company.springapp.domain.Role;
import com.company.springapp.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }

}
