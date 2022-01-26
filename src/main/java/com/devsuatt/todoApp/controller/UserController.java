package com.devsuatt.todoApp.controller;

import com.devsuatt.todoApp.dto.CreateUserRequestDto;
import com.devsuatt.todoApp.dto.UserDto;
import com.devsuatt.todoApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestBody CreateUserRequestDto requestDto)
    {
        return ResponseEntity.ok(userService.createUser(requestDto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable String userId)
    {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

}
