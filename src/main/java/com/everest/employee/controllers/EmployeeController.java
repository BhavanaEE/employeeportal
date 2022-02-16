package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/{first_name}/{last_name}")
    public List<Employee> getEmployeeByName(@PathVariable("first_name") String firstName,@PathVariable("last_name") String lastName) {
        return employeeService.getEmployeeByName(firstName,lastName);
    }
}
