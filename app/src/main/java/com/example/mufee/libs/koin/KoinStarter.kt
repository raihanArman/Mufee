package com.example.mufee.libs.koin

import android.content.Context
import com.example.mufee.data.di.ApiClientModule
import com.example.mufee.data.di.RepositoryModule
import com.example.mufee.domain.di.UseCaseModule
import com.example.mufee.libs.network.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object KoinStarter {
    fun onCreate(context: Context, featureModule: List<Module> = emptyList()) {
        val modules = listOf(
            NetworkModule.modules(),
            ApiClientModule.modules(),
            RepositoryModule.modules(),
            UseCaseModule.modules(),
        ) + featureModule
        startKoin {
            androidContext(context)
            modules(modules)
        }
    }
}