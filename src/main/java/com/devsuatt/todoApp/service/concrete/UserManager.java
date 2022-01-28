package com.devsuatt.todoApp.service.concrete;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UpdateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.UserViewDto;
import com.devsuatt.todoApp.dto.converter.UserDtoConverter;
import com.devsuatt.todoApp.exception.UserNotFoundException;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.UserRepository;
import com.devsuatt.todoApp.service.zabstract.UserService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserManager(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserViewDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userDtoConverter.convertToViewDto(user))
                .collect(Collectors.toList());
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User could not find by id: " + id));
    }

    public UserDto getUserById(String userId) {
        return userDtoConverter.convert(findUserById(userId));
    }

    public UserDto createUser(CreateUserRequestDto requestDto) {
        final User user = userRepository.save(new User( "",
                requestDto.getUsername(),
                requestDto.getPassword(),
                new HashSet<>()));
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserViewDto updateUser(UpdateUserRequestDto requestDto) {
        final User user = findUserById(requestDto.getId());
        user.setUsername(requestDto.getUsername());
        user.setPassword(requestDto.getPassword());
        return userDtoConverter.convertToViewDto(userRepository.save(user));
    }

    public void deleteUserById(String id) {
        final User user = findUserById(id);
        userRepository.deleteById(user.getId());
    }

}
