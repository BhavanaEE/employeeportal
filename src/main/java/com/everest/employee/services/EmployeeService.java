package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    public Employee updateEmployee(Long id,Employee updateEmployee){
        Employee employee = jpaEmployeeRepository.findById(updateEmployee.getEmployeeId()).orElse(updateEmployee);
        employee.setEmployeeId(id);
        return jpaEmployeeRepository.save(updateEmployee);
    }
}
