package com.playtech.jpa.salaries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryModel {

    private String id;

    private int salary;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String employeeId;
}
