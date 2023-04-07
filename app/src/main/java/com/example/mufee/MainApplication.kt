package com.example.mufee

import android.app.Application
import com.example.mufee.libs.koin.KoinStarter
import com.example.mufee.ui.feature.movie.di.MovieModule

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinStarter.onCreate(
            this,
            listOf(
                MovieModule.modules()
            )
        )
    }

}