package com.devsuatt.todoApp.dto

import org.hibernate.validator.constraints.UniqueElements
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateUserRequestDto(
    @field:NotBlank(message = "username can not be null!")
    @field:UniqueElements
    val username: String?,
    @field:NotBlank(message = "password can not be null!")
    @field:Size(min = 4, message = "password length must be greater than 3")
    val password: String?,
)
