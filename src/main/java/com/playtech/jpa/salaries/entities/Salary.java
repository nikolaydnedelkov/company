package com.playtech.jpa.salaries.entities;

import com.playtech.jpa.employees.entities.Employee;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

import static com.playtech.jpa.constants.Constants.UUID_SIZE;

@Data
@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = UUID_SIZE)
    private String id;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false)
    private LocalDate fromDate;

    @Column(nullable = false)
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_salaries_employees"))
    private Employee employee;
}
