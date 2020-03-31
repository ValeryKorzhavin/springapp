package com.company.springapp.controller;

import com.company.springapp.controller.dto.RoleDto;
import com.company.springapp.controller.dto.mapper.RoleMapper;
import com.company.springapp.controller.exception.RoleNotFoundException;
import com.company.springapp.domain.Role;
import com.company.springapp.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    private RoleMapper roleMapper;

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleMapper.toRoleDtoList(roleService.findAll());
    }

    @GetMapping("/{id}")
    public RoleDto getRole(@PathVariable Long id) {
        return roleMapper
            .toRoleDto(roleService.getRole(id)
            .orElseThrow(() -> new RoleNotFoundException(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody RoleDto roleDto) {
        Role role = roleMapper.toRole(roleDto);
        roleService.saveRole(role);
    }

    @PutMapping
    public void updateRole(@RequestBody RoleDto roleDto) {
        Role role = roleMapper.toRole(roleDto);
        roleService.saveRole(role);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id) {
        roleService.getRole(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
        roleService.deleteRole(id);
    }

}
