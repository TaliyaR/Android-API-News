package com.example.apiexample.activities.list.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.api.response.Article

class NewsListAdapter(
    private var list: List<Article>,
    private val clickLambda: (Article) -> Unit
) : RecyclerView.Adapter<NewsListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListHolder =
        NewsListHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsListHolder, position: Int) {
        holder.bind(list[position])
    }

    fun update(updateList: List<Article>){
        this.list = updateList
        notifyDataSetChanged()
    }
}
