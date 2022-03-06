package com.shirobutton.dependency_inversion.adapter

import com.shirobutton.dependency_inversion.application.IncrementUseCase
import javax.inject.Inject

class MainControllerImpl @Inject constructor(
    private val incrementUseCase: IncrementUseCase
): MainController  {
    override fun onIncrementButtonClick(number: Int) = incrementUseCase(number)
}