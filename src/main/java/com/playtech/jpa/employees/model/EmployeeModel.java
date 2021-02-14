package com.playtech.jpa.employees.model;

import com.playtech.jpa.employees.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private String id;

    private LocalDate birthDate;

    private String firstName;

    private String lastName;

    private Gender gender;

    private LocalDate hireDate;

    private String tasks;
}
