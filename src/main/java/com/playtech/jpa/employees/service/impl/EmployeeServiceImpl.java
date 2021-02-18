package com.playtech.jpa.employees.service.impl;

import com.playtech.jpa.employees.entities.Employee;
import com.playtech.jpa.employees.entities.EmployeeRepository;
import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.employees.service.EmployeeService;
import com.playtech.jpa.employees.service.converter.EmployeeConverter;
import com.playtech.jpa.exceptions.HttpBadRequestException;
import com.playtech.jpa.titles.enitities.Title;
import com.playtech.jpa.titles.enitities.TitleRepository;
import com.playtech.jpa.titles.service.converter.TitleConverter;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeConverter employeeConverter;
    private final EmployeeRepository employeeRepository;
    private final TitleRepository titleRepository;
    private final TitleConverter titleConverter;

    @Override
    public EmployeeModel createEmployee(EmployeeModel model) {

        log.info("Create employee BEGIN: {}", model);

        final Employee employee = employeeConverter.convertToEntity(model);

        final Employee saved = employeeRepository.save(employee);

        log.info("Create employee END: {}", saved);

        return employeeConverter.convertToModel(saved);
    }

    @Override
    public void deleteEmployee(String id) {
        log.info("Delete employee by id BEGIN: {}", id);

        employeeRepository.deleteById(id);

        log.info("Delete employee by id END: {}", id);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel model) {
        log.info("Update employee BEGIN: {}", model);

        if (!employeeRepository.existsById(model.getId())) {
            throw new HttpBadRequestException("Employee entity does not exist for id: " + model.getId());
        }

        final Employee employee = employeeConverter.convertToEntity(model);

        final EmployeeModel updated = employeeConverter.convertToModel(employeeRepository.save(employee));

        log.info("Update employee END: {}", updated);

        return updated;
    }

    @Override
    public EmployeeModel getById(String id) {
        log.info("Get employee by id BEGIN: {}", id);

        final Optional<Employee> employeeOpt = employeeRepository.findById(id);

        EmployeeModel employee = null;
        if (employeeOpt.isPresent()) {
            employee = employeeConverter.convertToModel(employeeOpt.get());
        }

        log.info("Get employee by id END: {} {}", id, employee);

        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        log.info("Get all employees BEGIN: ");

        final List<Employee> all = employeeRepository.findAll();

        final List<EmployeeModel> employees = employeeConverter.convertToModels(all);

        log.info("Get all employees END: {}", employees);

        return employees;
    }
    @Override
    public List<EmployeeModel> getAllEmployeesByTitle(String title) {
        log.info("Get all employees by title name BEGIN: ");

        final List<Title> titles = titleRepository.findByTitle(title);

        final List<Employee> employees = employeeRepository.findByIdIn(titles.stream()
                                                                             .map(Title::getEmployee)
                                                                             .map(Employee::getId)
                                                                             .collect(Collectors.toList()));

        final List<EmployeeModel> employeeModels = employeeConverter.convertToModels(employees);


        log.info("Get all employees by title name END: {}", employeeModels);

        return employeeModels;
    }
}
