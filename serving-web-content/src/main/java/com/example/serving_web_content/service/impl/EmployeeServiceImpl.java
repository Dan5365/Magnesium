package com.example.serving_web_content.service.impl;

import com.example.serving_web_content.exception.ResourceNotFoundException;
import com.example.serving_web_content.mapper.EmployeeMapper;
import com.example.serving_web_content.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import com.example.serving_web_content.dto.EmployeeDto;
import com.example.serving_web_content.entity.Employee;
import com.example.serving_web_content.service.EmployeeService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id:"+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id:"+ employeeId)
        );

        employee.setFirstname(updatedEmployee.getFirstName());
        employee.setLastname(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee  updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id:"+ employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }
}
