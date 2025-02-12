package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser(Long userId);

    Optional<User> findUserEntityById(Long userId);

}

