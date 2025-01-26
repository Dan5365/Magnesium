package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createEmployee(UserDto userDto);

    UserDto getEmployeeById(Long employeeId);
    List<UserDto> getAllUsers();

    UserDto updateEmployee(Long employeeId, UserDto updatedEmployee);


    void deleteEmployee(Long employeeId);
}
