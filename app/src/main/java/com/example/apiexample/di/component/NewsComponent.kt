package com.example.apiexample.di.component

import com.example.apiexample.activities.details.DetailsActivity
import com.example.apiexample.activities.list.NewsListActivity
import com.example.apiexample.di.module.NewsModule
import com.example.apiexample.di.scope.NewsScope
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [NewsModule::class])
@NewsScope
interface NewsComponent {
    fun inject(newsListActivity: NewsListActivity)
    fun inject(detailsActivity: DetailsActivity)
}
