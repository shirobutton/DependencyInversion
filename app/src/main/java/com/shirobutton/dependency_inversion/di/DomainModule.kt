package com.shirobutton.dependency_inversion.di

import com.shirobutton.dependency_inversion.domain.Calculator
import com.shirobutton.dependency_inversion.domain.CalculatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Singleton
    @Binds
    abstract fun bindCalculator(calculator: CalculatorImpl): Calculator
}