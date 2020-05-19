package com.example.apiexample.activities.list.di.module

import androidx.lifecycle.ViewModel
import com.example.apiexample.activities.list.NewsListViewModel
import com.example.apiexample.activities.list.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class NewsViewModelModule{

    @IntoMap
    @Binds
    @ViewModelKey(NewsListViewModel::class)
    abstract fun bindCountriesViewModel(
        countriesViewModel: NewsListViewModel
    ): ViewModel
}
