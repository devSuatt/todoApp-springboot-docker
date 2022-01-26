package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.converter.TaskDtoConverter;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskType;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TaskDtoConverter converter;

    public TaskService(TaskRepository taskRepository, UserService userService, TaskDtoConverter converter) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.converter = converter;
    }

    public TaskDto createTask(CreateTaskRequestDto requestDto) {
        User user = userService.findCustomerById(requestDto.getUserId());
        Task task = new Task(requestDto.getTaskHeader(), requestDto.getTaskDescription(), user);
        return converter.convert(taskRepository.save(task));
    }

}
