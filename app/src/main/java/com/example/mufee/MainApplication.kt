package com.example.mufee

import android.app.Application
import com.example.mufee.libs.koin.KoinStarter

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
            )
        )
    }

}