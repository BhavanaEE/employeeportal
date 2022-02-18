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

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Transactional(readOnly = true)
    public Page<Employee> getAllEmployees(int page, int pageSize, String[] sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(getSortDirection(sortBy[1]), sortBy[0]));
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(orders));
        return jpaEmployeeRepository.findAll(pageable);
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

}
