package com.everest.employee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "Employee")
@Entity
@Data
public class Employee {
    @Id
    private int employeeId;
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
