package com.example.apiexample.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule{
    @Provides
    @Singleton
    fun provideApp(app: Application): Context = app.applicationContext
}
