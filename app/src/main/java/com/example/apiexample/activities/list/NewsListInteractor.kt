package com.example.apiexample.activities.list

import com.example.apiexample.api.response.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class NewsListInteractor @Inject constructor(
    private val newsListRepositoryImpl: NewsListRepositoryImpl) {

    fun getNewsByCountry(country: String): Single<NewsResponse> =
        newsListRepositoryImpl.getNewsByCountry(country)
}
