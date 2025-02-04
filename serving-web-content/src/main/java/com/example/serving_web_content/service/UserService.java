package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);


    void deleteUser(Long userId);
}
//34
