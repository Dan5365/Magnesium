package com.example.serving_web_content.mapper;

import com.example.serving_web_content.dto.EmployeeDto;
import com.example.serving_web_content.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
    return new EmployeeDto(
            employee.getId(),
            employee.getFirstname(),
            employee.getLastname(),
            employee.getEmail()
            employee.getBalance()
    );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
            return new Employee(
                    employeeDto.getId(),
                    employeeDto.getFirstName(),
                    employeeDto.getLastName(),
                    employeeDto.getEmail()
                    employeeDto.getBalance()
            );

    }
}
