package com.devsuatt.todoApp.dto

import com.devsuatt.todoApp.model.Task

data class UserDto(
    val id: String,
    val username: String,
    val password: String,
    val tasks: Set<Task> = emptySet(),
)
