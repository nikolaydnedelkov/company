package com.playtech.jpa.titles.service;

import com.playtech.jpa.employees.entities.Gender;
import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.employees.service.EmployeeService;
import com.playtech.jpa.salaries.model.SalaryModel;
import com.playtech.jpa.titles.model.TitleModel;
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
public class TestTitlesService {

    @Autowired
    private TitleService titleService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testTitle() {

        final EmployeeModel employee = createEmployee("Nikolay", "Nedelkov");
        final EmployeeModel createdEmployee = employeeService.createEmployee(employee);

        final TitleModel title1 = new TitleModel(null,
                "Junior Software Developer",
                LocalDate.of(2018, 10, 10),
                LocalDate.of(2019, 12, 1),
                createdEmployee);

        final TitleModel createdTitle1 = titleService.createTitle(title1);

        assertEquals(title1.getTitle(), createdTitle1.getTitle());
        assertEquals(title1.getFromDate(), createdTitle1.getFromDate());
        assertEquals(title1.getToDate(), createdTitle1.getToDate());
        assertEquals(title1.getEmployee(), createdTitle1.getEmployee());

        final TitleModel title2 = new TitleModel(null,
                "Software Engineer",
                LocalDate.of(2019, 12, 2),
                LocalDate.of(2022, 1, 1),
                createdEmployee);

        titleService.createTitle(title2);

        titleService.getAllTitlesByEmployee(createdEmployee.getId());

        final EmployeeModel employee2 = createEmployee("Emil", "Uzunov");
        final EmployeeModel createdEmployee2 = employeeService.createEmployee(employee2);

        final TitleModel titleEmil = new TitleModel(null,
                "Software Engineer",
                LocalDate.of(2019, 5, 22),
                LocalDate.of(2021, 8, 11),
                createdEmployee2);

        titleService.createTitle(titleEmil);

        titleService.getAllEmployeesByTitle("Software Engineer");
    }

    private EmployeeModel createEmployee(String firstName, String lastName) {
        return new EmployeeModel(null,
                LocalDate.of(1994, 10, 28),
                firstName,
                lastName,
                Gender.MALE,
                LocalDate.of(2018, 9, 1),
                "Sync");
    }
}
