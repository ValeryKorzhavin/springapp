package com.company.springapp.controller;

import com.company.springapp.controller.dto.UserDto;
import com.company.springapp.controller.dto.mapper.UserMapper;
import com.company.springapp.controller.exception.UserNotFoundException;
import com.company.springapp.domain.User;
import com.company.springapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private UserMapper userMapper;

    @GetMapping
    public List<UserDto> getUsers() {
        return userMapper.toUserDtoList(userService.findAll());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userMapper.toUserDto(userService
                .getUser(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService
                .getUser(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userService.deleteUser(id);
    }

}
