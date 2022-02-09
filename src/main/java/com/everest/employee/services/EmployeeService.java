package com.everest.employee.services;

import com.everest.employee.entities.Employee;
import com.everest.employee.entities.NameOfEmployee;
import com.everest.employee.repositories.JpaEmployeeRepository;
import com.everest.employee.repositories.JpaNameOfEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    private final NameOfEmployeeService nameOfEmployeeService;

    public List<Employee> getEmployeeByName(String firstName) {
        List<NameOfEmployee> employees = nameOfEmployeeService.getEmployeeByName(firstName);
        List<Employee> listOfEmployees=new ArrayList<>();
        for (NameOfEmployee noe:employees) {
            Optional<Employee> byId = jpaEmployeeRepository.findById(noe.getEmployeeId());
            Employee employee=byId.get();
            employee.setNameOfEmployee(noe);
            listOfEmployees.add(employee);
        }
        return listOfEmployees;
    }
}
