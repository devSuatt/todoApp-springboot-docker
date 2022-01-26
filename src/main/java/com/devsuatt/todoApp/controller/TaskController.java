package com.devsuatt.todoApp.controller;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.service.TaskService;
import com.devsuatt.todoApp.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("")
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto requestDto)
    {
        return ResponseEntity.ok(taskService.createTask(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable String id,
            @RequestBody UpdateTaskRequestDto requestDto)
    {
        return ResponseEntity.ok(taskService.updateTask(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id) {
        System.out.println("************************** => " + id);
        taskService.deleteTask(id);
        return ResponseEntity.ok(new GenericResponse("task deleted."));
    }

}
