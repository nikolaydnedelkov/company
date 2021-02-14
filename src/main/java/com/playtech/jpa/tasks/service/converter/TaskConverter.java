package com.playtech.jpa.tasks.service.converter;

import com.playtech.jpa.tasks.enitities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {

    public Task convertToEntity(final String name) {
        if (name == null) {
            return null;
        }
        return new Task(null, name);
    }
}
