package com.jonhbravo.flowdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowViewModel: ViewModel() {

    private val useCaseWithCache = FlowWithCacheUseCase()
    private val useCaseNoCache = FlowUseCase()

    fun getData() = liveData {
        val useCache = true
        if (useCache) {
            useCaseWithCache()
        }else {
            useCaseNoCache()
        }.collect {
            emit(it)
        }
    }
}