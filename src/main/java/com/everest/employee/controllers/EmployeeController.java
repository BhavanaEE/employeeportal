package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping(value = "")
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        final Employee employee=employeeRepository.getEmployeeById(id);
        if(employee!=null) return ResponseEntity.ok(employee);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        final Employee createdEmployee=employeeRepository.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
        return employeeRepository.updateEmployee(employee);
    }

    @DeleteMapping(value = "/{id}")
    public Employee deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
       return employeeRepository.deleteEmployee(id);
    }
}
