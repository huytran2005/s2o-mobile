package com.example.s2o.data.repository

import com.example.s2o.core.network.ApiResult
import com.example.s2o.data.remote.auth.AuthApi
import com.example.s2o.data.remote.auth.dto.LoginRequest
import com.example.s2o.data.remote.auth.dto.LoginResponse
import com.example.s2o.data.remote.auth.dto.RegisterRequest

class AuthRepository(
    private val api: AuthApi
) {

    suspend fun login(
        email: String,
        password: String
    ): ApiResult<LoginResponse> {
        return try {
            val response = api.login(LoginRequest(email, password))
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Login failed")
        }
    }

    suspend fun register(
        name: String,
        email: String,
        password: String,
        phone: String,
    ): ApiResult<Unit> {
        return try {
            api.register(RegisterRequest(name, email, password, phone))
            ApiResult.Success(Unit)
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Registration failed")
        }
    }
}
