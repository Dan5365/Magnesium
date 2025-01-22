package com.example.serving_web_content.controllers;


import com.example.serving_web_content.dto.EmployeeDto;
import com.example.serving_web_content.service.EmployeeService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@ RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
       EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
    return ResponseEntity.ok(employeeDto);
    }


    //Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    //Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
   return ResponseEntity.ok(employeeDto);
    }

    //Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}


