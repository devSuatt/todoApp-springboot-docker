package com.devsuatt.todoApp;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskType;
import com.devsuatt.todoApp.model.User;

import java.time.LocalDateTime;
import java.util.Set;

public class TestSupport {

    public User generateUser() {
        return new User("userId",
                "username",
                "password",
                Set.of());
    }

    public Task generateTask(String id, String header, String description, User user) {
        return new Task(id,
                "taskHeader",
                "taskDescription",
                LocalDateTime.now(),
                TaskType.TODO,
                user);
    }

    public CreateTaskRequestDto generateRequestDto() {
        return new CreateTaskRequestDto("userId",
                "taskHeader",
                "taskDescription");
    }

}
