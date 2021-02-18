package com.playtech.jpa.employees.rest;

import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/employee")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody final EmployeeModel employee) {
        employeeService.createEmployee(employee);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping
    public EmployeeModel updateEmployee(@RequestBody final EmployeeModel employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping
    public EmployeeModel findEmployee(@RequestParam final String id) {
        return employeeService.getById(id);
    }

    @GetMapping("/allByTitle")
    public List<EmployeeModel> getEmployeeTitles(@RequestParam final String title) {
        return employeeService.getAllEmployeesByTitle(title);
    }

//
//    @DeleteMapping("/{employeeId}")
//    public void deleteEmployee(@PathVariable("employeeId") final String employeeId) {
//        employeeService.deleteEmployee(employeeId);
//    }

}
