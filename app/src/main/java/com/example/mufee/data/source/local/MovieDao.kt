package com.example.mufee.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mufee.data.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 08/04/23
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie_entity")
    fun getMovies(): List<MovieEntity>
}