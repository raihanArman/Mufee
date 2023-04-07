package com.example.mufee.libs.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
class RetrofitBuilder {

    companion object{
        private const val BASE_URL = ""
    }

    private fun okhttp(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        return OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun gson() = GsonBuilder()
        .setLenient()
        .setPrettyPrinting()
        .create()

    fun build(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttp())
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .build()
    }

}