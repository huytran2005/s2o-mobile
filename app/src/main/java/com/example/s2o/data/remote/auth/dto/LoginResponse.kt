package com.example.s2o.data.remote.auth.dto

data class LoginResponse(
    val token: String,
    val user: UserDto
)

data class UserDto(
    val id: Int,
    val name: String
)
