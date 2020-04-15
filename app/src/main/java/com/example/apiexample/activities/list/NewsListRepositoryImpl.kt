package com.example.apiexample.activities.list

import com.example.apiexample.api.NewsService
import com.example.apiexample.api.response.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class  NewsListRepositoryImpl @Inject constructor(
    private val api: NewsService):
    NewsListRepository {

    override fun getNewsByCountry(country: String): Single<NewsResponse> =
        api.getNewsByCountry(country)

}
