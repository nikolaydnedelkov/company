package com.playtech.jpa.employees.service.converter;

import com.mysql.cj.util.StringUtils;
import com.playtech.jpa.employees.entities.Employee;
import com.playtech.jpa.employees.model.EmployeeModel;
import com.playtech.jpa.tasks.enitities.Task;
import com.playtech.jpa.tasks.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Component
@AllArgsConstructor
public class EmployeeConverter {

    private final TaskService taskService;

    public EmployeeModel convertToModel(final Employee employee) {
        if (employee == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        EmployeeModel model = mapper.map(employee, EmployeeModel.class);
        model.setTasks(toTasks(employee.getTasks()));
        return model;
    }

    private String toTasks(final Set<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }

        return String.join(",", tasks.stream()
                                     .map(Task::getName)
                                     .collect(toSet()));
    }

    public Employee convertToEntity(final EmployeeModel model) {
        if (model == null) {
            return null;
        }

        ModelMapper mapper = new ModelMapper();
        Employee employee = mapper.map(model, Employee.class);
        employee.setTasks(createTaskIfMissing(model.getTasks()));

        return employee;
    }

    private Set<Task> createTaskIfMissing(final String tasks) {
        if (StringUtils.isNullOrEmpty(tasks)) {
            return null;
        }

        final Set<String> extrasSet = new HashSet<>(Arrays.asList(tasks.split(",")));
        final Set<Task> entities = new HashSet<>();

        extrasSet.forEach(task -> {
            final Task byName = taskService.getByName(task);
            if (byName != null) {
                entities.add(byName);
            } else {
                entities.add(taskService.create(task));
            }
        });
        return entities;
    }

    public List<EmployeeModel> convertToModels(final List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return new ArrayList<>();
        }

        return employees.stream().map(this::convertToModel).collect(toList());
    }
}
