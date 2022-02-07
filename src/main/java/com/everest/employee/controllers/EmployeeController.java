package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public Employee getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

}
