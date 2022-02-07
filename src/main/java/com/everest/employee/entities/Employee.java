package com.everest.employee.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private Long EmployeeId;
//    private NameOfEmployee nameOfEmployee;
    private String everestEmailId;
    private String personalMailId;
    private String password;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoin;
    private String designation;
    private int experience;
    private String bio;
//    private Address presentAddress;
//    private Address permanentAddress;

}
