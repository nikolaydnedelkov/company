package com.playtech.jpa.salaries.service.converter;

import com.playtech.jpa.employees.entities.Employee;
import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.employees.service.converter.EmployeeConverter;
import com.playtech.jpa.salaries.entities.Salary;
import com.playtech.jpa.salaries.model.SalaryModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class SalaryConverter {

    private final EmployeeConverter employeeConverter;

    public SalaryModel convertToModel(final Salary salary) {
        if (salary == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        SalaryModel model = mapper.map(salary, SalaryModel.class);
        model.setEmployee(employeeConverter.convertToModel(salary.getEmployee()));
        return model;
    }

    public Salary convertToEntity(final SalaryModel model) {
        if (model == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        Salary salary = mapper.map(model, Salary.class);
        salary.setEmployee(employeeConverter.convertToEntity(model.getEmployee()));
        return salary;
    }

    public List<SalaryModel> convertToModels(final List<Salary> salaries) {
        if (salaries == null || salaries.isEmpty()) {
            return new ArrayList<>();
        }

        return salaries.stream().map(this::convertToModel).collect(toList());
    }
}
