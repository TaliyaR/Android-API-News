package com.example.apiexample.activities.list.data

import com.example.apiexample.data.response.NewsResponse
import io.reactivex.Single

interface NewsListRepository {

    fun getNewsByCountry(country: String): Single<NewsResponse>
}
