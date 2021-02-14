package com.playtech.jpa.employees.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByIdIn(List<String> id);
}
