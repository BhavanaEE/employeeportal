package com.everest.employee.entities;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Employee")
@Entity
@Data
public class Employee {
    @Id
    private Long employeeId;
    @OneToOne()
    @JoinColumn(name = "EmployeeId",referencedColumnName = "EmployeeId")
    private NameOfEmployee nameOfEmployee;
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
    @OneToOne
    @JoinColumn(name = "EmployeeId",referencedColumnName = "EmployeeId")
    private Address permanentAddress;

}
