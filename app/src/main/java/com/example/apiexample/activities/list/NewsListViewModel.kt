package com.example.apiexample.activities.list

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiexample.Response
import com.example.apiexample.api.NewsService
import com.example.apiexample.api.response.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class NewsListViewModel constructor(
    private val interactor: NewsListInteractor
) : ViewModel() {

    private var loadingLiveData = MutableLiveData<Boolean>()
    private var newsLiveData: MutableLiveData<Response<List<Article>>>? = null

    @MainThread
    fun getNewsList(): LiveData<Response<List<Article>>>? {
        newsLiveData = MutableLiveData()
        interactor
            .getNewsByCountry("ru")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.articles }
            .subscribeBy(onSuccess = {
                val newsLiveDataImm = newsLiveData
                newsLiveDataImm?.value = Response.success(it)
                newsLiveData = newsLiveDataImm
            }, onError = {
                val newLiveDataImm = newsLiveData
                newLiveDataImm?.value = Response.error(it)
                newsLiveData = newLiveDataImm
            })

        return newsLiveData
    }
}
