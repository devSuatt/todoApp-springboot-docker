package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.converter.UserDtoConverter;
import com.devsuatt.todoApp.exception.UserNotFoundException;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    protected User findCustomerById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User could not find by id: " + id));
    }

    public UserDto createUser(CreateUserRequestDto requestDto) {
        User user = userRepository.save(new User( "suat", "test123"));
        System.out.println(user);
        return userDtoConverter.convertToUserDto(userRepository.save(user));
    }
}
