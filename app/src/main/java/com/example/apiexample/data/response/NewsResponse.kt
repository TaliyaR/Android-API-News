package com.example.apiexample.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class NewsResponse(
    @SerializedName("articles")
    var articles: List<Article>
)
@Parcelize
data class Article(
    @SerializedName("author")
    var author: String?,
    @SerializedName("content")
    var content: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("source")
    var source: @RawValue Source,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var urlToImage: String
):Parcelable

@Parcelize
data class Source(
    @SerializedName("id")
    var id: @RawValue Any?,
    @SerializedName("name")
    var name: String?
):Parcelable
