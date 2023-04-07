package com.example.mufee.libs.network

import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object NetworkModule {
    fun modules() = module {
        single { RetrofitBuilder() }
    }
}