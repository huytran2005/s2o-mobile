package com.example.s2o.core.network

sealed class ApiResult<out T> {

    data class Success<T>(
        val data: T
    ) : ApiResult<T>()

    data class Error(
        val message: String,
        val code: Int? = null
    ) : ApiResult<Nothing>()

    object Loading : ApiResult<Nothing>()
}