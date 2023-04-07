package com.example.mufee.data.di

import com.example.mufee.libs.database.MovieDatabase
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 08/04/23
 */
object DaoModule {
    fun modules() = module {
        single { MovieDatabase.instances().movieDao() }
    }
}