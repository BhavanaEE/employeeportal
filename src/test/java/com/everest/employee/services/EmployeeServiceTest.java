package com.everest.employee.services;

import com.everest.employee.entities.Address;
import com.everest.employee.entities.Employee;
import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.repositories.JpaEmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    private EmployeeService employeeService;
    private JpaEmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(JpaEmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void shouldSaveSuccessfully() {
        Address presentAddress = new Address(1L, "Road no-3 lakshmi nagar colony", "saidabad", "Hyderabad","Telangana", 500059L, "India");
        Address permanentAddress = new Address(1L, "Road no-5 Prabha nagar colony", "Saroornagar", "Hyderabad","Telangana", 500050L, "India");
        Employee employee=new Employee(1L, "Bhavana", "Chivukula", "bhavana@everest.engineering", "bhavana@gmail.com", "secret", LocalDate.of(1999, 11, 14), LocalDate.of(2021, 8, 24), "Intern", 1, "Hi Im Bhavana", presentAddress, permanentAddress);
        when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee savedUser=employeeService.createEmployee(employee);
        assertThat(savedUser).isNotNull();
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    void shouldThrowErrorWhenSaveUserWithExistingEmail() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setEverestEmailId("bhavana.chivukula@everest.engineering");
        when(employeeRepository.findByEverestEmailId(employee.getEverestEmailId())).thenReturn(Optional.of(employee));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.createEmployee(employee));
        verify(employeeRepository, never()).save(any(Employee.class));
    }
}