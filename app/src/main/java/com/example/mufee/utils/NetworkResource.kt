package com.example.mufee.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * @author Raihan Arman
 * @date 07/04/23
 */

abstract class NetworkResource<T> {

    fun asFlow(): Flow<Resource<T>> = flow {
        // check if should fetch data from remote or not
        if (shouldFetchFromRemote()) {
            emit(Resource.Loading)
            val remoteResponse = safeApiCall(dispatcher = Dispatchers.IO) {
                remoteFetch()   // fetch the remote source provided
            }

            when (remoteResponse) {
                is ResultWrapper.Success -> {
                    if (shouldFetchRemoteAndSaveLocal()) {
                        remoteResponse.value?.let {
                            val localData = withContext(Dispatchers.IO) {
                                saveLocal(it)
                                localFetch()
                            }
                            emit(Resource.Success(model = localData))
                        }
                    } else {
                        emit(Resource.Success(model = remoteResponse.value))
                    }
                }
                is ResultWrapper.GenericError -> {
                    if (shouldFetchLocalOnError()) {
                        val localData = withContext(Dispatchers.IO) {
                            localFetch()
                        }
                        emit(Resource.Success(model = localData))
                    } else {
                        emit(
                            Resource.Error("Error")
                        )
                    }
                }
            }
        } else {
            // get from cache
            val localData = withContext(Dispatchers.IO) {
                localFetch()
            }
            emit(Resource.Success(model = localData))
        }

    }

    abstract suspend fun remoteFetch(): T
    open suspend fun saveLocal(data: T) {}
    open suspend fun localFetch(): T? = null
    open fun onFetchFailed(throwable: Throwable) = Unit
    open fun shouldFetchFromRemote() = true
    open fun shouldFetchRemoteAndSaveLocal() = false
    open fun shouldFetchLocalOnError() = false
}