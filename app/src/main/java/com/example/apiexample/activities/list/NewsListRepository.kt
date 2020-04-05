package com.example.apiexample.activities.list

import com.example.apiexample.api.ApiFactory
import com.example.apiexample.api.NewsService
import com.example.apiexample.api.response.NewsResponse
import io.reactivex.Single

class NewsListRepository {
    private val api: NewsService = ApiFactory.newsService

    fun getNewsByCountry(country: String): Single<NewsResponse> =
        api.getNewsByCountry(country)

}