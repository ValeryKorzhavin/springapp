package com.company.springapp.controller.dto.mapper;

import com.company.springapp.controller.dto.RoleDto;
import com.company.springapp.controller.dto.UserDto;
import com.company.springapp.domain.Role;
import com.company.springapp.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", qualifiedByName = "roleToRoleDto")
    UserDto toUserDto(User user);

    @Named("roleToRoleDto")
    RoleDto toRoleDto(Role role);

    @Mapping(target = "password", ignore = true)
    User toUser(UserDto userDto);

    List<UserDto> toUserDtoList(List<User> users);

}
