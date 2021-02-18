package com.playtech.jpa.employees.entities;

import com.playtech.jpa.tasks.enitities.Task;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

import static com.playtech.jpa.constants.Constants.UUID_SIZE;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = UUID_SIZE)
    private String id;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate hireDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_employees",
            joinColumns = {@JoinColumn(name = "employee_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_task_employees_employees"))},
            inverseJoinColumns = {@JoinColumn(name = "task_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_task_employees_tasks"))})
    private Set<Task> tasks;

}
