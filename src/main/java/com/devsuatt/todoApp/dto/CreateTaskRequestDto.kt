package com.devsuatt.todoApp.dto

import com.devsuatt.todoApp.model.TaskType
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class CreateTaskRequestDto(

    @field:NotBlank(message = "userId can not be null!")
    val userId: String,
    @field:NotBlank(message = "task header can not be null!")
    val taskHeader: String,
    val taskDescription: String?,


    )
