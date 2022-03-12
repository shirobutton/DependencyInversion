package com.shirobutton.dependency_inversion.di

import com.shirobutton.dependency_inversion.adapter.MainController
import com.shirobutton.dependency_inversion.adapter.MainControllerImpl
import com.shirobutton.dependency_inversion.adapter.MainPresenter
import com.shirobutton.dependency_inversion.adapter.MainPresenterImpl
import com.shirobutton.dependency_inversion.application.IncrementUseCaseOutputBoundary
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class AdapterModule {
    @ActivityScoped
    @Binds
    abstract fun bindMainController(mainController: MainControllerImpl): MainController

    @ActivityScoped
    @Binds
    abstract fun bindMainPresenter(mainPresenterImpl: MainPresenterImpl): MainPresenter
}