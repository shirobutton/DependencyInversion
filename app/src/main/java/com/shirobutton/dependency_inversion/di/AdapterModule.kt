package com.shirobutton.dependency_inversion.di

import com.shirobutton.dependency_inversion.adapter.MainController
import com.shirobutton.dependency_inversion.adapter.MainControllerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class AdapterModule {
    @ActivityScoped
    @Binds
    abstract fun bindMainController(mainController: MainControllerImpl): MainController
}