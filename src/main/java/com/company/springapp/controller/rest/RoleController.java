package com.company.springapp.controller.rest;

import com.company.springapp.controller.exception.RoleNotFoundException;
import com.company.springapp.domain.Role;
import com.company.springapp.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id) {
        Role role = roleService.getRole(id);
        if (role == null) throw new RoleNotFoundException(id);
        return role;
    }

    @PostMapping
    public void createRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @PutMapping
    public void updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        Role role = roleService.getRole(id);
        if (role == null) throw new RoleNotFoundException(id);
        roleService.deleteRole(id);
    }

}
