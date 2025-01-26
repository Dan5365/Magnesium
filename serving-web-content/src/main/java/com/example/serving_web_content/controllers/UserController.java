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

    //Add Employee REST API
    @PostMapping
    public ResponseEntity<UserDto> createEmployee(@ RequestBody UserDto userDto){
        UserDto savedEmployee = userService.createEmployee(userDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Get Users REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getEmployeeById(@PathVariable("id") Long employeeId){
       UserDto userDto = userService.getEmployeeById(employeeId);
    return ResponseEntity.ok(userDto);
    }


    //Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllEmployee(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    //Update Users REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                  @RequestBody UserDto updatedEmployee){
       UserDto userDto = userService.updateEmployee(employeeId, updatedEmployee);
   return ResponseEntity.ok(userDto);
    }

    //Delete Users REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        userService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}


