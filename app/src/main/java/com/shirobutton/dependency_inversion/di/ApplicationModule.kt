package com.shirobutton.dependency_inversion.di

import com.shirobutton.dependency_inversion.application.IncrementUseCase
import com.shirobutton.dependency_inversion.application.IncrementUseCaseInteractor
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
}