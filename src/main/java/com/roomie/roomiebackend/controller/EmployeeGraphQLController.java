package com.roomie.roomiebackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;
import com.roomie.roomiebackend.entity.Employee;
import com.roomie.roomiebackend.services.EmployeeService;

import lombok.Getter;
import lombok.Setter;

@RestController
public class EmployeeGraphQLController {
    @Autowired
    private EmployeeService employeeService;

    // get all employees  data
    @QueryMapping("getAllEmployees")
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeService.getAllEmployees();
    }

    //add new employee
    @MutationMapping("createEmployee")
    public Employee addEmployee(@Argument EmployeeInput employeeInput) {
        Employee employee = new Employee();
        employee.setFirstName(employeeInput.getFirstName());
        employee.setLastName(employeeInput.getLastName());
        employee.setJobTitle(employeeInput.getJobTitle());
        return employeeService.addEmployee(employee);
    }

    //update employee
    @MutationMapping("updateEmployee")
    public Employee updateEmployee(@Argument UpdateEmployeeInput updateEmployeeInput) {
        Employee employee = new Employee();
        employee.setFirstName(updateEmployeeInput.getFirstName());
        employee.setLastName(updateEmployeeInput.getLastName());
        employee.setJobTitle(updateEmployeeInput.getJobTitle());
        return employeeService.updateEmployee(updateEmployeeInput.getEmployeeId(),employee);
    }

    // get only one employee by id
    @QueryMapping("getOneEmployee")
    public Employee getOne(@Argument Long employeeId) {
        return employeeService.getOne(employeeId);
    }
    // hard delete for employee
    @MutationMapping("deleteEmployee")
    public String deleteEmployee(@Argument Long employeeId) {
        System.out.println(employeeId);
        return employeeService.deleteEmployee(employeeId);
    }
}

/**
 * EmployeeInput
 */
@Getter
@Setter
class EmployeeInput {
   

    private String firstName;

    private String lastName;

    private String jobTitle;

}
/*
 * update employee class
*/
@Getter
@Setter
class UpdateEmployeeInput {
    private Long employeeId;
    private String firstName;

    private String lastName;

    private String jobTitle;

}