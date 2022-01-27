package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.converter.UserDtoConverter;
import com.devsuatt.todoApp.exception.UserNotFoundException;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userDtoConverter.convert(user))
                .collect(Collectors.toList());
    }

    protected User findCustomerById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User could not find by id: " + id));
    }

    public UserDto getUserById(String userId) {
        return userDtoConverter.convert(findCustomerById(userId));
    }

    public UserDto createUser(CreateUserRequestDto requestDto) {
        final User user = userRepository.save(new User( "",
                requestDto.getUsername(),
                requestDto.getPassword(),
                new HashSet<>()));
        return userDtoConverter.convert(userRepository.save(user));
    }

    public void deleteUserById(String id) {
        final User user = findCustomerById(id);
        userRepository.deleteById(user.getId());
    }

}
