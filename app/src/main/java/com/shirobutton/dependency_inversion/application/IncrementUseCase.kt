package com.shirobutton.dependency_inversion.application

interface IncrementUseCase {
    operator fun invoke(number: Int): Int
}