package com.devsuatt.todoApp.service.zabstract;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UpdateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.dto.UserViewDto;
import com.devsuatt.todoApp.model.User;

import java.util.List;

public interface UserService {

    public List<UserViewDto> getUsers();

    public User findUserById(String id);

    public UserDto getUserById(String userId);

    public UserDto createUser(CreateUserRequestDto requestDto);

    public UserViewDto updateUser(UpdateUserRequestDto requestDto);

    public void deleteUserById(String id);

}
