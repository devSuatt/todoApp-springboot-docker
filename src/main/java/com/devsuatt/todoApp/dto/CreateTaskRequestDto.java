package com.devsuatt.todoApp.dto;

import com.devsuatt.todoApp.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CreateTaskRequestDto {
    @NotBlank(message = "userId can not be blank!")
    private String userId;
    @NotBlank(message = "task header can not be blank!")
    private String taskHeader;
    private String taskDescription;

}
