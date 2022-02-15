package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    public List<Employee> getAllEmployees(){
        return jpaEmployeeRepository.findAll();
    }

}
