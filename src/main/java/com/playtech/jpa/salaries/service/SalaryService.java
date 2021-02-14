package com.playtech.jpa.salaries.service;

import com.playtech.jpa.salaries.model.SalaryModel;

import java.util.List;

public interface SalaryService {

    SalaryModel createSalary(SalaryModel salaryModel);

    List<SalaryModel> getAllSalaries();

    List<SalaryModel> getAllSalariesByEmployee(String id);
}
