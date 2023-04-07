package com.example.mufee.libs.database

import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 08/04/23
 */
object DatabaseModule {
    fun modules() = module {
        single { MovieDatabase.build(androidContext()) }
    }
}