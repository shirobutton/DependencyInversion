package com.shirobutton.dependency_inversion.application

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumberSubjectImpl @Inject constructor(): NumberSubject, IncrementUseCaseOutputBoundary {
    private val mutableNumberFlow = MutableSharedFlow<Int>()
    override val flow: Flow<Int> get() = mutableNumberFlow

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun incrementOutput(number: Int) {
        coroutineScope.launch {
            mutableNumberFlow.emit(number)
        }
    }
}