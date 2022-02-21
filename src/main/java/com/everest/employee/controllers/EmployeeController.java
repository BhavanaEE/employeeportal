package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.models.EmployeesResult;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "")
    public EmployeesResult getAllEmployees(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int pageSize, @RequestParam(value = "sort", defaultValue = "firstName,asc") String[] sortBy) {
        Page<Employee> allEmployees = employeeService.getAllEmployees(page, pageSize, sortBy);
        return new EmployeesResult(allEmployees);
    }

    @PostMapping(value = "")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "/search")
    public EmployeesResult findByName(@RequestParam("query") String searchKeyword, @RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "size", defaultValue = "10") int pageSize,@RequestParam(value = "sort", defaultValue = "firstName,asc") String[] sortBy) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (sortBy[1].equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        }
        Sort sort = Sort.by(direction, sortBy[0]);
        Page<Employee> employeePage = employeeService.getEmployeeByName(searchKeyword, page, pageSize, sort);
        return new EmployeesResult(employeePage);
    }

    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }
}