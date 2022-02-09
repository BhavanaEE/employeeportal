package com.everest.employee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NameOfEmployee")
public class NameOfEmployee {
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
}
