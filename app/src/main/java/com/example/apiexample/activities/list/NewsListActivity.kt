package com.example.apiexample.activities.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.activities.details.DetailsActivity
import com.example.apiexample.activities.details.DetailsActivity.Companion.openDetails
import com.example.apiexample.activities.list.rv.NewsListAdapter
import com.example.apiexample.activities.viewModel.ViewModelFactory
import com.example.apiexample.api.response.Article
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class NewsListActivity : AppCompatActivity() {

    @Inject
    private lateinit var viewModelFactory: ViewModelFactory


    private lateinit var viewModel: NewsListViewModel
    private var adapter: NewsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelFactory = ViewModelFactory()
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(NewsListViewModel::class.java)
        initRecycler()
        observeNewsList()
    }

    private fun observeNewsList() {
        viewModel.getNewsList()?.observe(this, Observer {
            when {
                it.data != null -> {
                    adapter?.update(it.data)
                }
                it.error != null -> {
                    Snackbar.make(
                        container, it.error.message
                            ?: "We have problem", Snackbar.LENGTH_SHORT
                    )
                }
                else -> {
                    Snackbar.make(container, "We have problem", Snackbar.LENGTH_SHORT)
                }
            }
        })
    }

    private fun initRecycler() {
        adapter = NewsListAdapter(ArrayList(0)) {
            navigateToDetailsActivity(it)
        }
        rv_articles.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rv_articles.adapter = adapter
    }

    private fun navigateToDetailsActivity(article: Article) {
        startActivity(DetailsActivity.openDetails(this, article))
    }
}
