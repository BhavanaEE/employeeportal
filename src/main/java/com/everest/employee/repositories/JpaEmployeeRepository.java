package com.everest.employee.repositories;

import com.everest.employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaEmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByFirstNameContainingOrLastNameContaining(String firstName,String lastName);
}
