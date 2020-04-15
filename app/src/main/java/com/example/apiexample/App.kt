package com.example.apiexample

import android.app.Application
import com.example.apiexample.di.component.AppComponent

class App: Application {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

    }
}
