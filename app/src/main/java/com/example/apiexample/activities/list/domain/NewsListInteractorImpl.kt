package com.example.apiexample.activities.list.domain

import com.example.apiexample.activities.list.data.NewsListRepository
import com.example.apiexample.data.response.NewsResponse
import io.reactivex.Single

class NewsListInteractorImpl (
    private val newsListRepositoryImpl: NewsListRepository
): NewsListInteractor {

    override fun getNewsByCountry(country: String): Single<NewsResponse> =
        newsListRepositoryImpl.getNewsByCountry(country)
}
