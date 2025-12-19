package com.example.s2o.data.remote.auth

import com.example.s2o.data.remote.auth.dto.LoginRequest
import com.example.s2o.data.remote.auth.dto.LoginResponse
import com.example.s2o.data.remote.auth.dto.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Unit // Giả sử server trả về 201 No Content hoặc bạn có thể tạo RegisterResponse nếu cần
}
