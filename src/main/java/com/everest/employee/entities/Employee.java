package com.everest.employee.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Employee id shouldn't be null")
    private Long employeeId;
    @NotBlank(message = "Firstname shouldn't be blank")
    private String firstName;
    @NotBlank(message = "Lastname shouldn't be blank")
    private String lastName;
    @NotBlank(message = "Email shouldn't be blank")
    @Email(message = "Email is not valid",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@$" + "everest.engineering")
    private String everestEmailId;
    @NotBlank(message = "Mail shouldn't be blank")
    @Email(message = "Email is not valid",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String personalMailId;
    @NotBlank(message = "Password shouldn't be blank")
    private String password;
    @NotNull(message = "Date of birth shouldn't be blank")
    private LocalDate dateOfBirth;
    @NotNull(message = "Date of join shouldn't be blank")
    private LocalDate dateOfJoin;
    @NotBlank(message = "Designation shouldn't be blank")
    private String designation;
    private int experience;
    private String bio;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "presentAddressId")
    private Address presentAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanentAddressId")
    private Address permanentAddress;
}
