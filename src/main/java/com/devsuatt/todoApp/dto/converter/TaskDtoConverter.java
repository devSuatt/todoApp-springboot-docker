package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {

    private final TaskUserDtoConverter converter;

    public TaskDtoConverter(TaskUserDtoConverter converter) {
        this.converter = converter;
    }

    public TaskDto convert(Task from) {
        return new TaskDto(from.getId(),
                from.getHeader(),
                from.getDescription(),
                from.getTransactionDate(),
                from.getTaskType()
//                from.getCategory()
        );
    }

}
