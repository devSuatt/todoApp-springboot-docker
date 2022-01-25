package com.devsuatt.todoApp.dto

import com.devsuatt.todoApp.model.Category
import com.devsuatt.todoApp.model.TaskType
import com.devsuatt.todoApp.model.User
import java.time.LocalDateTime

data class TaskDto(

    val id: String?,
    val header: String?,
    val description: String?,
    val creationDate: LocalDateTime?,
    val taskType: TaskType? = TaskType.TODO,
    val user: User?,
    val category: Category?,

    )
