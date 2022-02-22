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
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    private Employee employee;
    @BeforeEach
    void setUp() {
        Address presentAddress = new Address(1L, "Road no-3 lakshmi nagar colony", "saidabad", "Hyderabad","Telangana", 500059L, "India");
        Address permanentAddress = new Address(1L, "Road no-5 Prabha nagar colony", "Saroornagar", "Hyderabad","Telangana", 500050L, "India");
        employee=new Employee(1L, "Bhavana", "Chivukula", "bhavana@everest.engineering", "bhavana@gmail.com", "secret",LocalDate.of(1999, 11, 14), LocalDate.of(2021, 8, 24), "Intern", 1, "Hi Im Bhavana", presentAddress, permanentAddress);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void getEmployeeById() throws Exception {
        Long employeeId=1L;
        given(employeeService.getEmployeeById(employeeId)).willReturn(employee);
        this.mockMvc.perform(get("/api/employees/{id}", employeeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.everestEmailId", is(employee.getEverestEmailId())))
                .andExpect(jsonPath("$.personalMailId", is(employee.getPersonalMailId())))
                .andExpect(jsonPath("$.password", is(employee.getPassword())))
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())));
    }
}