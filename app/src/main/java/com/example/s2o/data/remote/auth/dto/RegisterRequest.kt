package com.example.s2o.data.remote.auth.dto

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone: String
)
