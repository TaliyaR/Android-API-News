package com.example.apiexample.di.module

import com.example.apiexample.api.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)
}
