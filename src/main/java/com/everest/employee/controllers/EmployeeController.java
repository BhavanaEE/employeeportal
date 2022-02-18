package com.everest.employee.controllers;

import com.everest.employee.entities.Employee;
import com.everest.employee.models.EmployeesResult;
import com.everest.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/search")
    public EmployeesResult findByName(@RequestParam("query") String searchKeyword, @RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "size", defaultValue = "10") int pageSize,@RequestParam(value = "sort", defaultValue = "firstName,asc") String[] sortBy) {
        Sort.Direction direction= Sort.Direction.ASC;
        if (sortBy[1].equalsIgnoreCase("desc")){ direction= Sort.Direction.DESC;}
        Sort sort= Sort.by(direction,sortBy[0]);
        Page<Employee> employeePage = employeeService.getEmployeeByName(searchKeyword,page,pageSize,sort);
        return new EmployeesResult(employeePage);
    }
}
