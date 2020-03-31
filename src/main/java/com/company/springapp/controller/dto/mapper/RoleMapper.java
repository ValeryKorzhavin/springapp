package com.company.springapp.controller.dto.mapper;

import com.company.springapp.controller.dto.RoleDto;
import com.company.springapp.domain.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "extId", ignore = true)
    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<RoleDto> toRoleDtoList(List<Role> roles);

}
