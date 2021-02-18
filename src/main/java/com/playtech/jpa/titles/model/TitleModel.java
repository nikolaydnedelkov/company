package com.playtech.jpa.titles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleModel {

    private String id;

    private String title;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String employeeId;
}
