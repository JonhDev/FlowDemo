package com.jonhbravo.flowdemo

import com.jonhbravo.flowdemo.models.FlowState
import com.jonhbravo.flowdemo.models.ApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FlowRepository {

    suspend fun getDataFromDataBase() = withContext(Dispatchers.IO) {
        ApiModel(
            listOf(
                "Database item 1",
                "Database item 2",
                "Database item 3"
            )
        )
    }

    suspend fun getDataFromApi() = withContext(Dispatchers.IO) {
        delay(1500)
        ApiModel(
            listOf(
                "Api item 1",
                "Api item 2",
                "Api item 3",
                "Api item 4"
            )
        )

    }
}