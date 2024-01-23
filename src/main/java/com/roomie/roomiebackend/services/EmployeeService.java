package com.roomie.roomiebackend.services;

import java.util.List;

import com.roomie.roomiebackend.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee getOne(Long id);
    Employee updateEmployee(Long id, Employee updatedEmployee);
    String deleteEmployee(Long id);
} 
