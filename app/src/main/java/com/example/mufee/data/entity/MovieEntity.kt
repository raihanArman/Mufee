package com.example.mufee.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Raihan Arman
 * @date 08/04/23
 */

@Entity(tableName = "movie_entity")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var poster: String,
)
