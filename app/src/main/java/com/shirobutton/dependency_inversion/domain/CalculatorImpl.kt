package com.shirobutton.dependency_inversion.domain

import javax.inject.Inject

class CalculatorImpl @Inject constructor(): Calculator {
    override fun increment(number: Int) = number + 1
}