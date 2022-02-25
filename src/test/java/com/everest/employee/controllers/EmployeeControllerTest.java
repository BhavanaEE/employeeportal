package com.everest.employee.controllers;

import com.everest.employee.entities.Address;
import com.everest.employee.entities.Employee;
import com.everest.employee.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        this.employees=new ArrayList<>();
        Address presentAddress = new Address(1L, "Road no-3 lakshmi nagar colony", "saidabad", "Hyderabad","Telangana", 500059L, "India");
        Address permanentAddress = new Address(2L, "Road no-5 Prabha nagar colony", "Saroornagar", "Hyderabad","Telangana", 500050L, "India");
        Address presentAddress2 = new Address(3L, "Road no -6 lakshmi nagar colony", "saidabad", "Hyderabad","Telangana", 500059L, "India");
        Address permanentAddress2 = new Address(4L, "Road no-7 Prabha nagar colony", "Saroornagar", "Hyderabad","Telangana", 500050L, "India");

        Employee employee1=new Employee(1L, "Bhavana", "Chivukula", "bhavana@everest.engineering", "bhavana@gmail.com", "secret", LocalDate.of(1999, 11, 14), LocalDate.of(2021, 8, 24), "Intern", 1, "Hi Im Bhavana", presentAddress, permanentAddress);
        Employee employee2=new Employee(2L, "Ankita", "Vinja", "ankita@everest.engineering", "ankita@gmail.com", "secret123",LocalDate.of(2003, 11, 06), LocalDate.of(2021, 8, 24), "Intern", 1, "Hi Im Anki", presentAddress2, permanentAddress2);

        employees.add(employee1);
        employees.add(employee2);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down process");
    }

    @Test
    void shouldFetchAllEmployees() throws Exception {
        Page<Employee> employeePage = new PageImpl<>(this.employees);
        when(employeeService.getAllEmployees(any(Pageable.class))).thenReturn(employeePage);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPage", equalTo(1)))
                .andExpect(jsonPath("$.hasNext", equalTo(false)))
                .andExpect(jsonPath("$.hasPrevious", equalTo(false)))
                .andExpect(jsonPath("$.totalPages", equalTo(1)))
                .andExpect(jsonPath("$.data.size()", is(this.employees.size())));
    }
}