package com.devsuatt.todoApp.dto;

import com.devsuatt.todoApp.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserViewDto {

    private String id;
    private String username;
    private String password;

}
