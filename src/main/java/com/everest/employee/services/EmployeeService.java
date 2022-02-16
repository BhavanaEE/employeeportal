package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    public ResponseEntity<Employee> deleteEmployee(Long id) {
        Employee employee = jpaEmployeeRepository.findById(id).orElse(null);
        if (employee == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        jpaEmployeeRepository.deleteById(id);
        return ResponseEntity.ok(employee);
    }
}
