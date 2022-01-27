package com.devsuatt.todoApp.controller;

import com.devsuatt.todoApp.dto.*;
import com.devsuatt.todoApp.service.UserService;
import com.devsuatt.todoApp.shared.GenericResponse;
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
    public ResponseEntity<List<UserViewDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserViewDto> updateUser(
            @Valid @RequestBody UpdateUserRequestDto requestDto)
    {
        return ResponseEntity.ok(userService.updateUser(requestDto));
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(
            @PathVariable String id)
    {
        userService.deleteUserById(id);
        return ResponseEntity.ok(new GenericResponse("user deleted"));
    }

}
