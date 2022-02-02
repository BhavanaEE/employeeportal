package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Employee getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeRepository.getEmployeeById(id);
    }

    @PostMapping(value = "")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.createEmployee(employee);
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
