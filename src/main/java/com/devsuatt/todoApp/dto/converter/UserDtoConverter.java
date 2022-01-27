package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskUserDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.UserViewDto;
import com.devsuatt.todoApp.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final TaskDtoConverter taskDtoConverter;

    public UserDtoConverter(TaskDtoConverter taskDtoConverter) {
        this.taskDtoConverter = taskDtoConverter;
    }

    public UserViewDto convertToViewDto(User from) {
        return new UserViewDto(from.getId(),
                from.getUsername(),
                from.getPassword()
        );
    }

    public UserDto convert(User from) {
        return new UserDto(from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getTasks()
                        .stream()
                        .map(taskDtoConverter::convert)
                        .collect(Collectors.toSet())
        );
    }

}
