package com.everest.employee.services;

import com.everest.employee.entities.NameOfEmployee;
import com.everest.employee.repositories.JpaNameOfEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NameOfEmployeeService {
    private final JpaNameOfEmployeeRepository jpaNameOfEmployeeRepository;

    public List<NameOfEmployee> getEmployeeByName(String firstName) {
        return jpaNameOfEmployeeRepository.findByFirstName(firstName);
    }
}
