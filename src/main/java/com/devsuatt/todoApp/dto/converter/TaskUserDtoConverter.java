package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskUserDto;
import com.devsuatt.todoApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class TaskUserDtoConverter {

    public TaskUserDto convertToTaskUserDto(User from) {
        return new TaskUserDto(from.getId(),
                from.getUsername(),
                from.getPassword()
        );
    }

}
