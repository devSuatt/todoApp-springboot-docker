package com.devsuatt.todoApp.dto;

import com.devsuatt.todoApp.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TaskDto {
    private String id;
    private String header;
    private String description;
    private LocalDateTime transactionDate;
    private TaskType taskType;
}
