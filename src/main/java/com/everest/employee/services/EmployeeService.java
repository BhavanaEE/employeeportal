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

    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> getById = jpaEmployeeRepository.findById(id);
        if(getById.isEmpty()) throw new EmployeeNotFoundException("No employee found with employee id  "+id);
        return getById.get();
    }
}
