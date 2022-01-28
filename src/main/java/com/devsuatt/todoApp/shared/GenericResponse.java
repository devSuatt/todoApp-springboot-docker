package com.devsuatt.todoApp.shared;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GenericResponse {
    private String message;

    public GenericResponse(String message) {
        this.message = message;
    }
}
