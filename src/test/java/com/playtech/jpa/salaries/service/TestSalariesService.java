package com.playtech.jpa.salaries.service;

import com.playtech.jpa.employees.entities.Gender;
import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.employees.service.EmployeeService;
import com.playtech.jpa.salaries.model.SalaryModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestSalariesService {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSalary() {

        final EmployeeModel employee = createEmployee();
        final EmployeeModel createdEmployee = employeeService.createEmployee(employee);

        final SalaryModel salary1 = new SalaryModel(null,
                10,
                LocalDate.of(2018, 10, 10),
                LocalDate.of(2019, 12, 1),
                createdEmployee);

        final SalaryModel createdSalary1 = salaryService.createSalary(salary1);

        assertEquals(salary1.getSalary(), createdSalary1.getSalary());
        assertEquals(salary1.getFromDate(), createdSalary1.getFromDate());
        assertEquals(salary1.getToDate(), createdSalary1.getToDate());
        assertEquals(salary1.getEmployee(), createdSalary1.getEmployee());

        final SalaryModel salary2 = new SalaryModel(null,
                20,
                LocalDate.of(2019, 12, 2),
                LocalDate.of(2022, 1, 1),
                createdEmployee);

        final SalaryModel createdSalary2 = salaryService.createSalary(salary2);


        salaryService.getAllSalariesByEmployee(createdEmployee.getId());

    }

    private EmployeeModel createEmployee() {
        return new EmployeeModel(null,
                LocalDate.of(1994, 10, 28),
                "Nikolay",
                "Nedelkov",
                Gender.MALE,
                LocalDate.of(2018, 9, 1),
                "Sync, SQL, GPAS Glorious Guardians");
    }

}
