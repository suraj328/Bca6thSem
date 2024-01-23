package com.roomie.roomiebackend.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roomie.roomiebackend.entity.Employee;
import com.roomie.roomiebackend.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee getOne(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setJobTitle(updatedEmployee.getJobTitle());
        return employeeRepository.save(existingEmployee);
    }
    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}
