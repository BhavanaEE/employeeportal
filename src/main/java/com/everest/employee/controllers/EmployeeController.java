package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
       return employeeService.deleteEmployee(id);
    }
}
