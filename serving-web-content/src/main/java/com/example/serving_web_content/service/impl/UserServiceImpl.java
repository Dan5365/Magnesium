package com.example.serving_web_content.service.impl;

import com.example.serving_web_content.exception.ResourceNotFoundException;
import com.example.serving_web_content.mapper.UserMapper;
import com.example.serving_web_content.repository.UserRepository;
import lombok.AllArgsConstructor;
import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.entity.User;
import com.example.serving_web_content.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with given id:" + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id:" + userId)
        );

        user.setFirstname(updatedUser.getFirstName());
        user.setLastname(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id:" + userId)
        );
        userRepository.deleteById(userId);
        logger.info("User with ID {} was successfully deleted!", userId);
    }
}