package com.jonhbravo.flowdemo

import com.jonhbravo.flowdemo.models.FlowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FlowUseCase(
    private val repository: FlowRepository = FlowRepository()
) {
    operator fun invoke() = flow {
        emit(FlowState.loading())
        emit(FlowState.success(repository.getDataFromApi()))
    }.flowOn(Dispatchers.IO)
}