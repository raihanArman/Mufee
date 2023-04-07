package com.example.mufee.utils

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
sealed class Resource<out T> {
    data class Success<T>(val model: T? = null) : Resource<T>()
    data class Error(val errorMessage: String) : Resource<Nothing>()
    object Idle: Resource<Nothing>()
    object ErrorInternet: Resource<Nothing>()
    object Loading : Resource<Nothing>()
    object None : Resource<Nothing>()
}
