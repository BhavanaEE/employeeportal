package com.everest.employee.repositories;

import com.everest.employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmployeeRepository extends JpaRepository<Employee,Integer> {

}
