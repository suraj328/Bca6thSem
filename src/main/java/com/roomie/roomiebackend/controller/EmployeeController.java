package com.roomie.roomiebackend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.roomie.roomiebackend.entity.Employee;
import com.roomie.roomiebackend.services.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return employeeService.getOne(id);
    }
}
