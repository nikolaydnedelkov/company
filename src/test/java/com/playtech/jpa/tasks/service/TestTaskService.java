package com.playtech.jpa.tasks.service;

import com.playtech.jpa.tasks.enitities.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestTaskService {

    @Autowired
    private TaskService taskService;

    @Test
    public void testCreateGetTask() {
        assertNull(taskService.getByName("SQL Registration"));

        final Task task = taskService.create("SQL Registration");

        assertEquals("SQL Registration", task.getName());

        taskService.create("Sync BE");

        final String sync_be = taskService.getByName("Sync BE").getName();

        assertNotNull(sync_be);
    }

}
