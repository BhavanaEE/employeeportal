package com.everest.employee.entities;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private Long employeeId;
    private String addressLane1;
    private String addressLane2;
    private String city;
    private String state;
    private Long zipcode;
    private String country;
}
