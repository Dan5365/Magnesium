package com.example.serving_web_content.repository;

import com.example.serving_web_content.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
