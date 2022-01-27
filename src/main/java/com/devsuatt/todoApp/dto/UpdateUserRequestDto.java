package com.devsuatt.todoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequestDto {
    @NotBlank(message = "user id can not be blank!")
    private String id;
    @NotBlank(message = "username can not be blank!")
    private String username;
    @NotBlank(message = "password can not be blank!")
    private String password;

}
