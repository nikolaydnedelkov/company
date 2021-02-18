package com.playtech.jpa.salaries.rest;

import com.playtech.jpa.salaries.model.SalaryModel;
import com.playtech.jpa.salaries.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/salaries")
@RequiredArgsConstructor
public class SalariesController {

    private final SalaryService salaryService;

    @PostMapping("/addSalary")
    public void createSalary(@RequestBody final SalaryModel salary) {
        salaryService.createSalary(salary);
    }

    @GetMapping("/allSalaries")
    public List<SalaryModel> getAllSalaries() {
        return salaryService.getAllSalaries();
    }


    @GetMapping("/allSalariesByEmpoleeId")
    public List<SalaryModel> getAllSalaries(@RequestParam final String id) {
        return salaryService.getAllSalariesByEmployee(id);
    }

}
