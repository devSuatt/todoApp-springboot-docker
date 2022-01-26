package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {

    private final UserDtoConverter userDtoConverter;

    public TaskDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public TaskDto convert(Task from) {
        return new TaskDto(from.getId(),
                from.getHeader(),
                from.getDescription(),
                from.getCreationDate(),
                from.getTaskType(),
                userDtoConverter.convertToTaskUserDto(from.getUser())
//                from.getCategory()
        );
    }

}
