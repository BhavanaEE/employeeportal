package com.everest.employee.repositories;

import com.everest.employee.entities.NameOfEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaNameOfEmployeeRepository extends JpaRepository<NameOfEmployee,Long> {
    List<NameOfEmployee> findByFirstName(String firstName);
}
