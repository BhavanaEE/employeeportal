package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.everest.employee.exceptions.EmployeeNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Transactional(readOnly = true)
    public Page<Employee> getAllEmployees(int page, int pageSize, String[] sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy[0].contains(",")) {
            for (String sortOrder : sortBy) {
                String[] sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sortBy[1]), sortBy[0]));
        }
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(orders));
        return jpaEmployeeRepository.findAll(pageable);
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    public Employee createEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeById(Long id) {
        Optional<Employee> getById = jpaEmployeeRepository.findById(id);
        if (getById.isEmpty()) throw new EmployeeNotFoundException("No employee found with employee id  " + id);
        return getById.get();
    }

    public ResponseEntity<Employee> deleteEmployee(Long id) {
        Employee employee = jpaEmployeeRepository.findById(id).orElse(null);
        if (employee == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        jpaEmployeeRepository.deleteById(id);
        return ResponseEntity.ok(employee);
    }

    @Transactional(readOnly = true)
    public Page<Employee> getEmployeeByName(String name, Pageable pageable) {
        return jpaEmployeeRepository.findByFirstNameContainingOrLastNameContaining(name, name, pageable);
    }

    public Employee updateEmployee(Long id, Employee updateEmployee) {
        Optional<Employee> byId = jpaEmployeeRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EmployeeNotFoundException("Give proper employee id");
        }
        Employee employee = byId.get();
        employee.setEmployeeId(id);
        return jpaEmployeeRepository.save(updateEmployee);
    }
}
