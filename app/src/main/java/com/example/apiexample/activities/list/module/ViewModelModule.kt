package com.example.apiexample.activities.list.module

import androidx.lifecycle.ViewModelProvider
import com.example.apiexample.activities.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory
}
