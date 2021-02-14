package com.playtech.jpa.employees.service;

import com.playtech.jpa.employees.entities.Gender;
import com.playtech.jpa.employees.model.EmployeeModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestEmployeeService {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCRUDemployee() {
        final EmployeeModel model = new EmployeeModel(null,
                LocalDate.of(1994, 10, 28),
                "Nikolay",
                "Nedelkov",
                Gender.MALE,
                LocalDate.of(2018, 9, 1),
                "Sync, SQL, GPAS Glorious Guardians");

        final EmployeeModel created = employeeService.createEmployee(model);

        assertEquals(model.getFirstName(), created.getFirstName());
        assertEquals(model.getLastName(), created.getLastName());
        assertEquals(model.getGender(), created.getGender());
        assertEquals(model.getBirthDate(), created.getBirthDate());
        assertEquals(model.getHireDate(), created.getHireDate());
        assertEquals(Arrays.stream(model.getTasks().split(",")).collect(Collectors.toSet()),
                Arrays.stream(created.getTasks().split(",")).collect(Collectors.toSet()));


        final EmployeeModel byId = employeeService.getById(created.getId());
        assertNotNull(byId);

        byId.setGender(Gender.FEMALE);
        final EmployeeModel updated = employeeService.updateEmployee(byId);
        assertEquals(byId.getGender(), updated.getGender());

        final List<EmployeeModel> allEmployees = employeeService.getAllEmployees();
        assertTrue(allEmployees.size() > 0);

        employeeService.deleteEmployee(updated.getId());

        final EmployeeModel deleted = employeeService.getById(updated.getId());
        assertNull(deleted);
    }
}
