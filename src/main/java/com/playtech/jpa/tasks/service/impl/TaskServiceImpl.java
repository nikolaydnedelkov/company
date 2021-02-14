package com.playtech.jpa.tasks.service.impl;

import com.playtech.jpa.tasks.enitities.Task;
import com.playtech.jpa.tasks.enitities.TaskRepository;
import com.playtech.jpa.tasks.service.TaskService;
import com.playtech.jpa.tasks.service.converter.TaskConverter;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;

    @Override
    public Task create(String name) {
        log.info("Create task BEGIN: {}", name);

        if (name == null) {
            return null;
        }

        final Task taskEntity = taskConverter.convertToEntity(name);
        final Task created = taskRepository.save(taskEntity);

        log.info("Create task END: {}", created);

        return created;
    }

    @Override
    public Task getByName(String name) {

        log.info("Get task by name BEGIN: {}", name);

        if (name == null) {
            return null;
        }

        final Optional<Task> departmentOpt = taskRepository.findByName(name);
        final Task task = departmentOpt.orElse(null);

        log.info("Get task by name BEGIN: {}", task);

        return task;
    }
}
