package com.example.serving_web_content.mapper;

import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.entity.User;

public class userMapper {
    public static UserDto mapToUserDto(User user){
    return new UserDto(
            user.getId(),
            user.getFirstname(),
            user.getLastname(),
            user.getEmail(),
            user.getBalance()
    );
    }
    public static User mapToUser(UserDto userDto){
            return new User(
                    userDto.getId(),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    userDto.getEmail(),
                    userDto.getBalance()
            );

    }
}
