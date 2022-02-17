package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> getById = jpaEmployeeRepository.findById(id);
        if(getById.isEmpty()) throw new EmployeeNotFoundException("No employee found with employee id  "+id);
        return getById.get();
    }
}
