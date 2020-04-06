package com.example.apiexample.api

import com.example.apiexample.api.response.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getNewsByCountry(
        @Query("country") country: String): Single<NewsResponse>
}
