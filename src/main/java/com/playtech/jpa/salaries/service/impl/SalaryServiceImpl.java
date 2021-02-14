package com.playtech.jpa.salaries.service.impl;

import com.playtech.jpa.salaries.entities.Salary;
import com.playtech.jpa.salaries.entities.SalaryRepository;
import com.playtech.jpa.salaries.model.SalaryModel;
import com.playtech.jpa.salaries.service.SalaryService;
import com.playtech.jpa.salaries.service.converter.SalaryConverter;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final SalaryConverter salaryConverter;

    @Override
    public SalaryModel createSalary(SalaryModel model) {
        log.info("Create salary BEGIN: {}", model);

        final Salary entity = salaryConverter.convertToEntity(model);

        final Salary salary = salaryRepository.save(entity);

        final SalaryModel created = salaryConverter.convertToModel(salary);

        log.info("Create salary END: {}", created);

        return created;
    }

    @Override
    public List<SalaryModel> getAllSalaries() {
        log.info("Get all salaries BEGIN: ");

        final List<Salary> all = salaryRepository.findAll();

        final List<SalaryModel> salaries = salaryConverter.convertToModels(all);

        log.info("Get all salaries END: {}", salaries);

        return salaries;
    }

    @Override
    public List<SalaryModel> getAllSalariesByEmployee(String id) {
        log.info("Get all salaries by employee ID BEGIN: ");

        final List<Salary> allEmployeeSalaries = salaryRepository.findByEmployeeId(id);

        final List<SalaryModel> salaries = salaryConverter.convertToModels(allEmployeeSalaries);

        log.info("Get all salaries by employee ID END: {}", salaries);

        return salaries;
    }
}
