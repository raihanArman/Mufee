package com.example.mufee.utils.exception

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object ErrorCodesMapper {
    fun getMessage(errorCode: Int) = when (errorCode) {
        NetworkCodes.CONNECTION_ERROR,
        NetworkCodes.TIMEOUT_ERROR -> "Failed to connect to server please check you network!"
        else -> "Something went wrong please try again!"
    }
}