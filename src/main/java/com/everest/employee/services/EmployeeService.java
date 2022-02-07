package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    public Employee updateEmployee(Long id,Employee updateEmployee) throws EmployeeNotFoundException {
        Optional<Employee> getId = jpaEmployeeRepository.findById(id);
        if(getId.isEmpty()) throw new EmployeeNotFoundException();
        return jpaEmployeeRepository.save(updateEmployee);
    }
}
