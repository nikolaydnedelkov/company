package com.playtech.jpa.salaries.service.converter;

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

    public SalaryModel convertToModel(final Salary salary) {
        if (salary == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        return mapper.map(salary, SalaryModel.class);
    }

    public Salary convertToEntity(final SalaryModel model) {
        if (model == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        return mapper.map(model, Salary.class);
    }

    public List<SalaryModel> convertToModels(final List<Salary> salaries) {
        if (salaries == null || salaries.isEmpty()) {
            return new ArrayList<>();
        }

        return salaries.stream().map(this::convertToModel).collect(toList());
    }
}
