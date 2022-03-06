package com.shirobutton.dependency_inversion.di

import android.app.Activity
import com.shirobutton.dependency_inversion.adapter.MainReceiver
import com.shirobutton.dependency_inversion.driver.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object DriverModule {

    @ActivityScoped
    @Provides
    fun provideMainReceiver(activity: Activity) = activity as MainReceiver
}