package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.TestSupport;
import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.converter.TaskDtoConverter;
import com.devsuatt.todoApp.exception.TaskNotFoundException;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskType;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.TaskRepository;
import com.devsuatt.todoApp.service.concrete.TaskManager;
import com.devsuatt.todoApp.service.zabstract.TaskService;
import com.devsuatt.todoApp.service.zabstract.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.mock;

class TaskServiceTest extends TestSupport {

    private TaskRepository taskRepository;
    private UserService userService;
    private TaskDtoConverter converter;

    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskRepository = mock(TaskRepository.class);
        userService = mock(UserService.class);
        converter = mock(TaskDtoConverter.class);

        taskService = new TaskManager(taskRepository, userService, converter);
    }

    @Test
    public void testFindByTaskId_whenTaskIdExists_shouldReturnTask() {
        Task task = generateTask("id", "header", "description", new User());

        Mockito.when(taskRepository.findById(task.getId()))
                .thenReturn(Optional.of(task));

        Task result = taskService.findTaskById(task.getId());

        assertEquals(result, task);
    }

    @Test
    public void testFindByTaskId_whenTaskIdDoesNotExists_shouldThrowTaskNotFoundException() {
        Mockito.when(taskRepository.findById("id"))
                .thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
                () -> taskService.findTaskById("id"));
    }

    @Test
    public void testCreateTask_whenUserIdExist_shouldCreateTask() {
        CreateTaskRequestDto requestDto = generateRequestDto();
        User user = generateUser();
        Task task = generateTask("","taskHeader", "taskDescription", user);
        TaskDto expected = new TaskDto("taskId",
                "taskHeader",
                "taskDescription",
                LocalDateTime.now(),
                TaskType.TODO);

        Mockito.when(userService.findUserById(requestDto.getUserId())).thenReturn(user);
        Mockito.when(taskRepository.save(task)).thenReturn(task);
        Mockito.when(converter.convert(task)).thenReturn(expected);

        TaskDto result = taskService.createTask(requestDto);

    }

}