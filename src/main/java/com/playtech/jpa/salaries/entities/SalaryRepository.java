package com.playtech.jpa.salaries.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, String> {

    List<Salary> findByEmployeeId(String id);
}
