package com.example.serving_web_content.controllers;


import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
     private UserService userService;


    //Add user REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //Get Users REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long UserId){
       UserDto userDto = userService.getUserById(UserId);
    return ResponseEntity.ok(userDto);
    }


    //Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    //Update Users REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                                  @RequestBody UserDto updatedUser){
       UserDto userDto = userService.updateUser(userId, updatedUser);
   return ResponseEntity.ok(userDto);
    }

    //Delete Users REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long UserId){
        userService.deleteUser(UserId);
        return ResponseEntity.ok("User deleted successfully");
    }
}


