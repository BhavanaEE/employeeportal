package com.everest.employee.services;

import com.everest.employee.exceptions.EmployeeNotFoundException;
import com.everest.employee.repositories.JpaEmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    private JpaEmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(JpaEmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void shouldThrowErrorWhenEmployeeDoesNotExist() {
        long empId = 1;
        when(employeeRepository.findById(empId)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(empId));

        verify(employeeRepository).findById(anyLong());
    }
}