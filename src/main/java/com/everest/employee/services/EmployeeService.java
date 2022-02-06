package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Data
@Component
public class EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    public List<Employee> getAllEmployees(){
        return jpaEmployeeRepository.findAll();
    }

}
