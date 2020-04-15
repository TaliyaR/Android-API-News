package com.example.apiexample.di.module

import com.example.apiexample.activities.list.NewsListRepositoryImpl
import com.example.apiexample.activities.list.NewsListRepository
import com.example.apiexample.api.NewsService
import dagger.Module
import dagger.Provides

@Module
class NewsModule {
    @Provides
    fun provideNewsRepository(newsService: NewsService): NewsListRepository =
        NewsListRepositoryImpl(newsService)
}
