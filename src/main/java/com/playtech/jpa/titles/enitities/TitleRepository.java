package com.playtech.jpa.titles.enitities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, String> {

    List<Title> findByEmployeeId(String id);

    List<Title> findByTitle(String title);

}
