package com.playtech.jpa.titles.rest;

import com.playtech.jpa.titles.model.TitleModel;
import com.playtech.jpa.titles.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/titles")
@RequiredArgsConstructor
public class TitlesController {

    private final TitleService titleService;

    @PostMapping("/addTitle")
    public void createTitle(@RequestBody final TitleModel title) {
        titleService.createTitle(title);
    }

    @GetMapping("/allTitles")
    public List<TitleModel> getAllTitles() {
        return titleService.getAllTitles();
    }


    @GetMapping("/allTitlesByEmpoleeId")
    public List<TitleModel> getAllTitlesByEmployee(@RequestParam final String id) {
        return titleService.getAllTitlesByEmployee(id);
    }

}
