package com.playtech.jpa.tasks.service;

import com.playtech.jpa.tasks.enitities.Task;

public interface TaskService {
    Task create(String name);

    Task getByName(String name);
}
