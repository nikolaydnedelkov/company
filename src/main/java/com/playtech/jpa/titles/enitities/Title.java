package com.playtech.jpa.titles.enitities;

import com.playtech.jpa.employees.entities.Employee;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

import static com.playtech.jpa.constants.Constants.UUID_SIZE;

@Data
@Entity
@Table(name = "titles")
public class Title {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = UUID_SIZE)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate fromDate;

    @Column(nullable = false)
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_titles_employees"))
    private Employee employee;

}

