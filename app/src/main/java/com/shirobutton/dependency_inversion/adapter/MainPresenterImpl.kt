package com.shirobutton.dependency_inversion.adapter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(): MainPresenter {
    private val mutableNumberFlow = MutableSharedFlow<Int>()
    override val numberFlow get() = mutableNumberFlow

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun incrementOutput(number: Int) {
        coroutineScope.launch {
            mutableNumberFlow.emit(number)
        }
    }
}