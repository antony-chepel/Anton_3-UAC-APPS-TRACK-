package com.skgames.trafficridert.utils

sealed class StateConnetion<T> {
    class Loading<T> : StateConnetion<T>()
    data class Success<T>(val data: T) : StateConnetion<T>()
    data class Failed<T>(val message: String) : StateConnetion<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failed<T>(message)
    }
}
