package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.model.User;

public class UserDtoConverter {

    public UserDto convert(User from) {
        return new UserDto(from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getTasks()
        );
    }

}
