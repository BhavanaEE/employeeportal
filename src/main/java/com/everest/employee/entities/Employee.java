package com.everest.employee.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String everestEmailId;
    private String personalMailId;
    private String password;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoin;
    private String designation;
    private int experience;
    private String bio;
    @OneToOne()
    @JoinColumn(name = "EmployeeId",referencedColumnName = "EmployeeId")
    private Address presentAddress;
    @OneToOne()
    @JoinColumn(name = "EmployeeId",referencedColumnName = "EmployeeId")
    private Address permanentAddress;
}
