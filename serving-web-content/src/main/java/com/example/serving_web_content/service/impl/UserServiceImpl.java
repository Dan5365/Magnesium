package com.example.serving_web_content.service.impl;

import com.example.serving_web_content.exception.ResourceNotFoundException;
import com.example.serving_web_content.mapper.userMapper;
import com.example.serving_web_content.repository.UserRepository;
import lombok.AllArgsConstructor;
import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.entity.User;
import com.example.serving_web_content.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createEmployee(UserDto userDto) {
        User user = userMapper.mapToEmployee(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToEmployeeDto(savedUser);
    }

    @Override
    public UserDto getEmployeeById(Long employeeId) {
        User user = userRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id:"+ employeeId));
        return userMapper.mapToEmployeeDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user)-> userMapper.mapToEmployeeDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateEmployee(Long employeeId, UserDto updatedEmployee) {
        User user = userRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id:"+ employeeId)
        );

        user.setFirstname(updatedEmployee.getFirstName());
        user.setLastname(updatedEmployee.getLastName());
        user.setEmail(updatedEmployee.getEmail());
        User updatedUserObj = userRepository.save(user);
        return userMapper.mapToEmployeeDto(updatedUserObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        User user = userRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id:"+ employeeId)
        );
        userRepository.deleteById(employeeId);
    }
}
