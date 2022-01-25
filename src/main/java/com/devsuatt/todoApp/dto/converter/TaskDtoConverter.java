package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {

    public TaskDto convert(Task from) {
        return new TaskDto(from.getId(),
                from.getHeader(),
                from.getDescription(),
                from.getCreationDate(),
                from.getTaskType(),
                from.getUser(),
                from.getCategory());
    }

}
