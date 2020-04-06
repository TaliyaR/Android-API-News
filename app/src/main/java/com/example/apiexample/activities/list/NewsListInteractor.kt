package com.example.apiexample.activities.list

import com.example.apiexample.api.response.NewsResponse
import io.reactivex.Single

class NewsListInteractor {
    val newsListRepository = NewsListRepository()

    fun getNewsByCountry(country: String): Single<NewsResponse> =
        newsListRepository.getNewsByCountry(country)
}
