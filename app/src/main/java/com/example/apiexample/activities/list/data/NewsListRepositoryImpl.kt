package com.example.apiexample.activities.list.data

import com.example.apiexample.data.NewsService
import com.example.apiexample.data.response.NewsResponse
import io.reactivex.Single

class  NewsListRepositoryImpl(private val api: NewsService
): NewsListRepository {

    override fun getNewsByCountry(country: String): Single<NewsResponse> =
        api.getNewsByCountry(country)

}
