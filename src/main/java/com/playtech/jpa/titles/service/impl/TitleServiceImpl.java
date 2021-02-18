package com.playtech.jpa.titles.service.impl;

import com.playtech.jpa.titles.enitities.Title;
import com.playtech.jpa.titles.enitities.TitleRepository;
import com.playtech.jpa.titles.model.TitleModel;
import com.playtech.jpa.titles.service.TitleService;
import com.playtech.jpa.titles.service.converter.TitleConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;
    private final TitleConverter titleConverter;

    @Override
    public TitleModel createTitle(TitleModel model) {
        log.info("Create title BEGIN: {}", model);

        final Title entity = titleConverter.convertToEntity(model);

        final Title title = titleRepository.save(entity);

        final TitleModel created = titleConverter.convertToModel(title);

        log.info("Create title END: {}", created);

        return created;
    }

    @Override
    public List<TitleModel> getAllTitles() {
        log.info("Get all titles BEGIN: ");

        final List<Title> all = titleRepository.findAll();

        final List<TitleModel> titles = titleConverter.convertToModels(all);

        log.info("Get all titles END: {}", titles);

        return titles;
    }

    @Override
    public List<TitleModel> getAllTitlesByEmployee(String id) {
        log.info("Get all titles by employee ID BEGIN: ");

        final List<Title> allEmployeeTitles = titleRepository.findByEmployeeId(id);

        final List<TitleModel> titles = titleConverter.convertToModels(allEmployeeTitles);

        log.info("Get all titles by employee ID END: {}", titles);

        return titles;
    }
}
