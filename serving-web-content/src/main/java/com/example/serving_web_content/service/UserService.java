package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long employeeId);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long employeeId, UserDto updatedEmployee);


    void deleteUser(Long employeeId);
}
