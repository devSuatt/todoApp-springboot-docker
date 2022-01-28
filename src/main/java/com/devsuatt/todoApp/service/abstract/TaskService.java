package com.devsuatt.todoApp.service.zabstract;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.model.Task;

import java.util.Set;

public interface TaskService {

    public Task findTaskById(String id);

    public TaskDto getTaskById(String id);

    public Set<TaskDto> getTasksByUserId(String id);

    public TaskDto createTask(CreateTaskRequestDto requestDto);

    public TaskDto updateTask(String id, UpdateTaskRequestDto requestDto);

    public void deleteTask(String id);

}
