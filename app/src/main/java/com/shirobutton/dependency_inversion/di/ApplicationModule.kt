package com.shirobutton.dependency_inversion.di

import com.shirobutton.dependency_inversion.application.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class ApplicationModule {
    @Binds
    abstract fun bindIncrementUseCase(
        incrementUseCase: IncrementUseCaseInteractor
    ): IncrementUseCase

    @Binds
    abstract fun bindNumberSubject(
        numberSubjectImpl: NumberSubjectImpl
    ): NumberSubject

    @Binds
    abstract fun bindIncrementUseCaseOutputBoundary(
        numberSubjectImpl: NumberSubjectImpl
    ): IncrementUseCaseOutputBoundary
}