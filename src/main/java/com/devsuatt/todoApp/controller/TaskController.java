package com.devsuatt.todoApp.controller;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.service.concrete.TaskManager;
import com.devsuatt.todoApp.service.zabstract.TaskService;
import com.devsuatt.todoApp.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/v1")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskManager taskManager) {
        this.taskService = taskManager;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Set<TaskDto>> getTasksByUserId(
            @PathVariable String id)
    {
        return ResponseEntity.ok(taskService.getTasksByUserId(id));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(
            @PathVariable String id)
    {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto requestDto)
    {
        return ResponseEntity.ok(taskService.createTask(requestDto));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable String id,
            @Valid @RequestBody UpdateTaskRequestDto requestDto)
    {
        return ResponseEntity.ok(taskService.updateTask(id, requestDto));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id) {
        taskService.deleteTask(id);
        GenericResponse response = new GenericResponse("task deleted");
        return ResponseEntity.ok(response);
    }

}
