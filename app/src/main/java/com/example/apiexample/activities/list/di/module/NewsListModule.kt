package com.example.apiexample.activities.list.di.module

import com.example.apiexample.activities.list.NewsListViewModel
import com.example.apiexample.activities.list.data.NewsListRepository
import com.example.apiexample.activities.list.data.NewsListRepositoryImpl
import com.example.apiexample.activities.list.di.scope.NewsListScope
import com.example.apiexample.activities.list.domain.NewsListInteractor
import com.example.apiexample.activities.list.domain.NewsListInteractorImpl
import com.example.apiexample.data.NewsService
import dagger.Module
import dagger.Provides

@Module
class NewsListModule {

    @Provides
    @NewsListScope
    fun provideNewsViewModel(interactor: NewsListInteractor): NewsListViewModel =
        NewsListViewModel(interactor)

    @Provides
    @NewsListScope
    fun provideNewsListInteractor(repository: NewsListRepository): NewsListInteractor =
        NewsListInteractorImpl(repository)

    @Provides
    @NewsListScope
    fun provideNewsListRepository(service: NewsService): NewsListRepository =
        NewsListRepositoryImpl(service)
}
