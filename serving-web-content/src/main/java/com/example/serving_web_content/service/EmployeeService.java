package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.EmployeeDto;
import com.example.serving_web_content.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);


    void deleteEmployee(Long employeeId);
}
