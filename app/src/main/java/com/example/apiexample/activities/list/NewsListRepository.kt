package com.example.apiexample.activities.list

import com.example.apiexample.api.response.NewsResponse
import io.reactivex.Single

interface NewsListRepository {

    fun getNewsByCountry(country: String): Single<NewsResponse>
}
