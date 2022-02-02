package com.everest.employee.repositories;

import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    private AtomicLong nextId = new AtomicLong(0);
    private Map<Long, Employee> employees = new HashMap<>();

    public List<Employee> getAllEmployees(){
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        if(!employees.containsKey(id)) throw new EmployeeNotFoundException();
        return employees.get(id);
    }

    public Employee createEmployee(Employee employee){
        employee.setEmployeeId(nextId.incrementAndGet());
        employees.put(employee.getEmployeeId(),employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
        if(!employees.containsKey(employee.getEmployeeId())) throw new EmployeeNotFoundException();
        employees.put(employee.getEmployeeId(),employee);
        return employee;
    }
    public Employee deleteEmployee(Long id) throws EmployeeNotFoundException {
        if(!employees.containsKey(id)) throw new EmployeeNotFoundException();
        return employees.remove(id);
    }
}
