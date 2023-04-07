package com.example.mufee.libs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mufee.data.entity.MovieEntity
import com.example.mufee.data.source.local.MovieDao
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * @author Raihan Arman
 * @date 08/04/23
 */
@Database(entities = [ MovieEntity::class ], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object: KoinComponent {
        fun build(context: Context): MovieDatabase {
            return Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                .build()
        }

        fun instances(): MovieDatabase {
            return get()
        }
    }
}