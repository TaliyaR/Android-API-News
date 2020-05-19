package com.example.apiexample.di

import com.example.apiexample.App
import com.example.apiexample.activities.list.di.component.NewsComponent
import com.example.apiexample.activities.list.di.component.NewsListComponent
import com.example.apiexample.di.component.AppComponent
import com.example.apiexample.di.component.DaggerAppComponent

object Injector {
    lateinit var appComponent: AppComponent
    private var newsComponent: NewsComponent? = null
    private var newsListComponent: NewsListComponent? = null

    fun init(app: App){
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusNewsComponent(): NewsComponent = newsComponent ?: appComponent
        .plusNewsComponentBuilder()
        .build().also {
            newsComponent = it
        }

    fun clearNewsComponent(){
        newsComponent = null
    }

    fun plusNewsListComponent(): NewsListComponent = newsListComponent ?: plusNewsComponent()
        .plusNewsListComponent()
        .build().also {
            newsListComponent = it
        }

    fun clearNewsListComponent(){
        newsListComponent = null
    }

}
