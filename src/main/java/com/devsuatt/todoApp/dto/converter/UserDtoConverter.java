package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskUserDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convertToUserDto(User from) {
        return new UserDto(from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getTasks()
        );
    }

    public TaskUserDto convertToTaskUserDto(User from) {
        return new TaskUserDto(from.getId(),
                from.getUsername(),
                from.getPassword()
        );
    }

}
