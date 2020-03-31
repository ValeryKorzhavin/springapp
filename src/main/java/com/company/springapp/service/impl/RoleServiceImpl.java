package com.company.springapp.service.impl;

import com.company.springapp.domain.Role;
import com.company.springapp.repository.RoleRepository;
import com.company.springapp.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> getRole(long id) {
        return roleDao.getRole(id);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    @Transactional
    public void deleteRole(long id) {
        roleDao.deleteRole(id);
    }

}
