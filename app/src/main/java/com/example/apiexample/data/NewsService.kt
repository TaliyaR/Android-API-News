package com.example.apiexample.data

import com.example.apiexample.data.response.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getNewsByCountry(
        @Query("country") country: String): Single<NewsResponse>
}
