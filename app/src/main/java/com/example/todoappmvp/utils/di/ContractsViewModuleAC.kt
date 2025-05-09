package com.example.todoappmvp.utils.di

import android.app.Activity
import com.example.todoappmvp.ui.main.MainContracts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ContractsViewModuleAC {
    @Provides
    fun provideMainContractsView(activity: Activity): MainContracts.View {
        return activity as MainContracts.View
    }
}