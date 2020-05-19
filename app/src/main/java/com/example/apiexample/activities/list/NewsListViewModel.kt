package com.example.apiexample.activities.list

import android.view.View
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiexample.activities.list.domain.NewsListInteractor
import com.example.apiexample.data.response.Article
import com.example.apiexample.data.response.NewsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class NewsListViewModel constructor(
    private val interactor: NewsListInteractor
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private lateinit var news: MutableLiveData<NewsResponse>
    val inProgress = MutableLiveData<Int>()

    @MainThread
    fun getNewsList(): LiveData<NewsResponse> {
        news = MutableLiveData()
        inProgress.value = View.VISIBLE
        disposable.add(
            interactor.getNewsByCountry("ru")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        inProgress.value = View.GONE
                        news.value = result
                    },
                    { error ->
                        inProgress.value = View.GONE
                    })
        )

            return news
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
