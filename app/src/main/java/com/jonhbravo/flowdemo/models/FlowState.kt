package com.jonhbravo.flowdemo.models

data class FlowState<out T>(val state: State, val data: T? = null, val error: Error? = null) {

    enum class State { SUCCESS, ERROR, LOADING, LOADING_ADVICE }

    companion object {

        fun <T> success(data: T?) = FlowState(State.SUCCESS, data)

        fun <T> loading() = FlowState<T>(State.LOADING)

        fun <T> loadingAdvice() = FlowState<T>(State.LOADING_ADVICE)

        fun <T> error(error: Error?) = FlowState<T>(State.ERROR, error = error)
    }

}

data class Error(
    val message: String? = null,
    val lastTimeUpdate: String? = null
)