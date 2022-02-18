package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.models.EmployeesResult;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "")
    public EmployeesResult getAllEmployees(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int pageSize, @RequestParam(value = "sort", defaultValue = "firstName,asc") String[] sortBy){
        Page<Employee> allEmployees = employeeService.getAllEmployees(page, pageSize, sortBy);
        return new EmployeesResult(allEmployees);
    }
}
