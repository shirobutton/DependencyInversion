package com.shirobutton.dependency_inversion.adapter

import com.shirobutton.dependency_inversion.application.IncrementUseCaseOutputBoundary
import kotlinx.coroutines.flow.Flow

interface MainPresenter: IncrementUseCaseOutputBoundary {
    val numberFlow: Flow<Int>
}