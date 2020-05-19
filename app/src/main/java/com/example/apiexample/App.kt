package com.example.apiexample

import android.app.Application
import com.example.apiexample.di.Injector

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}
