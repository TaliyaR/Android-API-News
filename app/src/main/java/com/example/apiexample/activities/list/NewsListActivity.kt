package com.example.apiexample.activities.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.activities.details.DetailsActivity
import com.example.apiexample.activities.list.rv.NewsListAdapter
import com.example.apiexample.activities.viewModel.ViewModelFactory
import com.example.apiexample.data.response.Article
import com.example.apiexample.di.Injector
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class NewsListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var adapter: NewsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Injector.plusNewsListComponent().inject(this)
        observeNewsList()
    }

    private fun observeNewsList() =
        initViewModel()?.getNewsList()?.observe(this, Observer {
            when {
                it.articles != null -> {
                    initRecycler(it.articles)
                }
                else -> {
                    Snackbar.make(container, "We have problem", Snackbar.LENGTH_SHORT).show()
                }
            }
        })

    private fun initViewModel() = ViewModelProvider(this, viewModelFactory).get(NewsListViewModel::class.java)

    private fun initRecycler(list: List<Article>) {
        adapter = NewsListAdapter(list) {
            navigateToDetailsActivity(it)
        }
        rv_articles.adapter = adapter
    }

    private fun navigateToDetailsActivity(article: Article) {
        startActivity(DetailsActivity.openDetails(this, article))
    }

    override fun onDestroy(){
        Injector.clearNewsListComponent()
        super.onDestroy()
    }
}
