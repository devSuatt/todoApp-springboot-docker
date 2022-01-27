package com.devsuatt.todoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class CreateUserRequestDto {
    @NotBlank(message = "username can not be blank!")
    private String username;
    @NotBlank(message = "password can not be blank!")
    @Size(min = 4, message = "password length must be greater than 3")
    private String password;

}
