package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.converter.TaskDtoConverter;
import com.devsuatt.todoApp.exception.TaskNotFoundException;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

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

    protected Task findTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task could not find by id: " + id));
    }

    public TaskDto getTaskById(String id) {
        return converter.convert(taskRepository.getById(id));
    }

    public Set<TaskDto> getTasksByUserId(String id) {
        UserDto userDto = userService.getUserById(id);
        return userDto.getTasks();
    }

    public TaskDto createTask(CreateTaskRequestDto requestDto) {
        User user = userService.findUserById(requestDto.getUserId());
        Task task = new Task(requestDto.getTaskHeader(),
                requestDto.getTaskDescription(),
                LocalDateTime.now(),
                user);

        return converter.convert(taskRepository.save(task));
    }

    public TaskDto updateTask(String id, UpdateTaskRequestDto requestDto) {
        User user = userService.findUserById(requestDto.getUserId());
        Task task = new Task(id,
                requestDto.getTaskHeader(),
                requestDto.getTaskDescription(),
                LocalDateTime.now(),
                requestDto.getTaskType(),
                user);
        return converter.convert(taskRepository.save(task));
    }

    public void deleteTask(String id) {
        final Task task = findTaskById(id);
        taskRepository.deleteById(task.getId());
    }

}
