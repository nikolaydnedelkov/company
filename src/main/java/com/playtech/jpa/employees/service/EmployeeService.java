package com.playtech.jpa.employees.service;

import com.playtech.jpa.employees.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    EmployeeModel createEmployee (EmployeeModel model);

    void deleteEmployee(String id);

    EmployeeModel updateEmployee(EmployeeModel model);

    EmployeeModel getById(String id);

    List<EmployeeModel> getAllEmployees();
    }
