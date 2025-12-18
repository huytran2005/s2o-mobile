package com.example.s2o.data.remote.auth

import com.example.s2o.data.remote.auth.dto.LoginRequest
import com.example.s2o.data.remote.auth.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST
interface AuthApi {
    @POST("api/authenticate")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}