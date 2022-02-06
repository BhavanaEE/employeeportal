package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;
    public Employee createEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }
}
