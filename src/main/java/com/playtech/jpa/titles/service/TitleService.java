package com.playtech.jpa.titles.service;

import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.titles.model.TitleModel;

import java.util.List;

public interface TitleService {

    TitleModel createTitle(TitleModel model);

    List<TitleModel> getAllTitles();

    List<TitleModel> getAllTitlesByEmployee(String id);

}
