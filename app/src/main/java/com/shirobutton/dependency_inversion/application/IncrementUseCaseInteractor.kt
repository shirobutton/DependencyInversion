package com.shirobutton.dependency_inversion.application

import com.shirobutton.dependency_inversion.domain.Calculator
import javax.inject.Inject

class IncrementUseCaseInteractor @Inject constructor(
    private val calculator: Calculator
): IncrementUseCase {
    override fun invoke(number: Int): Int = calculator.increment(number)
}