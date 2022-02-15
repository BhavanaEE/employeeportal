package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
