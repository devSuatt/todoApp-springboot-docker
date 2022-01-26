package com.devsuatt.todoApp.controller;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(CreateUserRequestDto requestDto) {
        return ResponseEntity.ok(userService.createUser(requestDto));
    }

}
