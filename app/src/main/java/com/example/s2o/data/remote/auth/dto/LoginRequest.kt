package com.example.s2o.data.remote.auth.dto

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val email: String,
    val password: String,
    
    @SerializedName("display_name")
    val displayName: String? = null,
    
    val phone: String? = null
)
