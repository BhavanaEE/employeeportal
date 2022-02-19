package com.everest.employee.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id shouldn't be null")
    private Long addressId;
    @NotBlank(message = "Address shouldn't be blank")
    private String addressLane1;
    private String addressLane2;
    @NotBlank(message = "City shouldn't be blank")
    private String city;
    @NotBlank(message = "State shouldn't be blank")
    private String state;
    private long zipcode;
    @NotBlank(message = "Country shouldn't be blank")
    private String country;

}
