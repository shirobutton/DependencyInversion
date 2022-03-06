package com.shirobutton.dependency_inversion.application

import com.shirobutton.dependency_inversion.adapter.MainPresenter
import com.shirobutton.dependency_inversion.domain.Calculator
import javax.inject.Inject

class IncrementUseCaseInteractor @Inject constructor(
    private val calculator: Calculator,
    private val presenter: MainPresenter
): IncrementUseCase {
    override fun invoke(number: Int) = calculator.increment(number).let(presenter::setNumber)
}