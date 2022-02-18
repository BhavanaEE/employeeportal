package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    public Page<Employee> getEmployeeByName(String name, int page, int pageSize, Sort sort) {
        Pageable pageable = PageRequest.of(page - 1, pageSize,sort);
        return jpaEmployeeRepository.findByFirstNameContainingOrLastNameContaining(name,name,pageable);
    }
}
