package com.jonhbravo.flowdemo

import com.jonhbravo.flowdemo.models.FlowState
import com.jonhbravo.flowdemo.models.UiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class FlowRepository {

    suspend fun getData(): Flow<FlowState<UiModel>> = flow {
        emit(getDataFromDataBase())
        emit(FlowState.loading())
        emit(getDataFromApi())
    }.flowOn(Dispatchers.IO)

    private suspend fun getDataFromDataBase() = withContext(Dispatchers.IO) {
        FlowState.success(
            UiModel(
                listOf(
                    "Database item 1",
                    "Database item 2",
                    "Database item 3"
                )
            )
        )
    }

    private suspend fun getDataFromApi() = withContext(Dispatchers.IO) {
        delay(1500)
        FlowState.success(
            UiModel(
                listOf(
                    "Api item 1",
                    "Api item 2",
                    "Api item 3",
                    "Api item 4"
                )
            )
        )
    }
}