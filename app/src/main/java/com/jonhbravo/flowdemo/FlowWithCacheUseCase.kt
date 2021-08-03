package com.jonhbravo.flowdemo

import com.jonhbravo.flowdemo.models.FlowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FlowWithCacheUseCase(
    private val repository: FlowRepository = FlowRepository()
) {

    operator fun invoke() = flow {
        val dbResponse = repository.getDataFromDataBase() //map si es necesario
        emit(FlowState.success(dbResponse))
        emit(if (dbResponse != null) {
            FlowState.loadingAdvice()
        } else {
            FlowState.loading()
        })
        emit(FlowState.success(repository.getDataFromApi()))
    }.flowOn(Dispatchers.IO)

}