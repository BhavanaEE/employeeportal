package com.everest.employee.repositories;

import com.everest.employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JpaEmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);

    Employee findByEverestEmailId(String everestEmailId);
}
