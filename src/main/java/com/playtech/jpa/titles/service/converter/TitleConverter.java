package com.playtech.jpa.titles.service.converter;

import com.playtech.jpa.employees.service.converter.EmployeeConverter;

import com.playtech.jpa.titles.enitities.Title;
import com.playtech.jpa.titles.model.TitleModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class TitleConverter {

    private final EmployeeConverter employeeConverter;

    public TitleModel convertToModel(final Title title) {
        if (title == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        return mapper.map(title, TitleModel.class);
    }

    public Title convertToEntity(final TitleModel model) {
        if (model == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        return mapper.map(model, Title.class);
    }

    public List<TitleModel> convertToModels(final List<Title> titles) {
        if (titles == null || titles.isEmpty()) {
            return new ArrayList<>();
        }

        return titles.stream().map(this::convertToModel).collect(toList());
    }
}
