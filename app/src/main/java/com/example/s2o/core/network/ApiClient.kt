package com.example.s2o.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://university-mailing-walks-creek.trycloudflare.com/"
    // ⚠️ 10.0.2.2 = localhost khi chạy Android Emulator

    private val okHttpClient = OkHttpClient.Builder()
        // .addInterceptor(AuthInterceptor()) // thêm sau
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}
