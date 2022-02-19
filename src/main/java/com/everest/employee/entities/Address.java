package com.everest.employee.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Id shouldn't be blank")
    private Long addressId;
    @NotBlank(message = "Address shouldn't be blank")
    private String addressLane1;
    private String addressLane2;
    @NotBlank(message = "City shouldn't be blank")
    private String city;
    @NotBlank(message = "State shouldn't be blank")
    private String state;
    @NotBlank(message = "Zipcode shouldn't be blank")
    private Long zipcode;
    @NotBlank(message = "Country shouldn't be blank")
    private String country;

}
