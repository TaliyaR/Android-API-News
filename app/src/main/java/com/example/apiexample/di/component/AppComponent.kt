package com.example.apiexample.di.component

import android.content.Context
import com.example.apiexample.App
import com.example.apiexample.api.NewsService
import com.example.apiexample.di.module.AppModule
import com.example.apiexample.di.module.NetModule
import com.example.apiexample.di.module.ServiceModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, ServiceModule::class])
interface AppComponent {
    fun plusNewsComponentBuilder(): NewsComponent.Builder

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }
}
