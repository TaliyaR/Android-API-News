package com.example.apiexample.activities.list.di.component

import com.example.apiexample.activities.list.NewsListActivity
import com.example.apiexample.activities.list.di.module.NewsListModule
import com.example.apiexample.activities.list.di.module.NewsViewModelModule
import com.example.apiexample.activities.list.di.scope.NewsListScope
import dagger.Subcomponent

@Subcomponent(modules = [NewsListModule::class, NewsViewModelModule::class])
@NewsListScope
interface NewsListComponent {

    fun inject(newsListActivity: NewsListActivity)

    @Subcomponent.Builder
    interface Builder {
        fun newsListModule(newsModule: NewsListModule): Builder

        fun build(): NewsListComponent
    }
}
