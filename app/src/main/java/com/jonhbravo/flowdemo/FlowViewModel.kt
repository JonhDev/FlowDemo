package com.jonhbravo.flowdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowViewModel: ViewModel() {

    private val repository = FlowRepository()

    fun getData() = liveData {
        repository.getData().collect {
            emit(it)
        }
    }
}