package com.everest.employee.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "Address")
@Entity
public class Address {
    @Id
    private Long employeeId;
    private String addressLane1;
    private String addressLane2;
    private String city;
    private String state;
    private Long zipcode;
    private String country;
}