package com.devsuatt.todoApp.dto

data class UserDto(
    val id: String,
    val username: String,
    val password: String,
    val tasks: Set<TaskDto> = emptySet(),
)
