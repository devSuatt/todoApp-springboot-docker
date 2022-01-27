package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.UserViewDto;
import com.devsuatt.todoApp.dto.converter.UserDtoConverter;
import com.devsuatt.todoApp.exception.UserNotFoundException;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private UserDtoConverter converter;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        converter = mock(UserDtoConverter.class);
        userService = new UserService(userRepository, converter);
    }

    @Test
    public void testFindByUserId_whenUserIdExists_shouldReturnUser() {
        User user = new User("id", "username", "password", Set.of());

        Mockito.when(userRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));

        User result = userService.findUserById(user.getId());

        assertEquals(result, user);
    }

    @Test
    public void testFindByUserId_whenUserIdDoesNotExists_shouldThrowUserNotFoundException() {
        Mockito.when(userRepository.findById("id"))
                .thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.findUserById("id"));
    }

    @Test
    public void testGetByUserId_whenUserIdExists_shouldReturnUserDto() {
        User customer = new User("id", "username", "password", Set.of());
        UserDto userDto = new UserDto("id", "username", "password", Set.of());

        Mockito.when(userRepository.findById("id"))
                .thenReturn(Optional.of(customer));
        Mockito.when(converter.convert(customer))
                .thenReturn(userDto);

        UserDto result = userService.getUserById("id");

        assertEquals(result,
                userDto);
    }

    @Test
    public void testGetByUserId_whenUserIdExists_shouldThrowCustomerNotFoundException() {
        Mockito.when(userRepository.findById("id"))
                .thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getUserById("id"));

        Mockito.verifyNoInteractions(converter);
    }

    @Test
    public void testCreateUser_withCreateUserRequestDto_shouldCreateUser() {
        final CreateUserRequestDto requestDto = new CreateUserRequestDto(
                "username",
                "password");
        final UserDto userDto = userService.createUser(requestDto);
        final User user = new User("id",
                "username",
                "password",
                Set.of());
        final UserDto result = converter.convert(user);
        assertEquals(result, userDto);
    }

}