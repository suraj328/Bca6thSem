package com.roomie.roomiebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.roomie.roomiebackend.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
};
