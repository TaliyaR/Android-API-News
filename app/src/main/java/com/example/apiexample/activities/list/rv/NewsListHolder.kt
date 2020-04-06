package com.example.apiexample.activities.list.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.api.response.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_article.view.*

class NewsListHolder(
    itemView: View,
    private val clickLambda: (Article) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(article: Article) {
        itemView.tv_tittle.text = article.title
        itemView.tv_description.text = article.description
        itemView.tv_source.text = article.source.name
        itemView.iv_cover
        loadPicture(itemView.iv_cover, article.urlToImage)

        itemView.setOnClickListener {
            clickLambda(article)
        }
    }

    private fun loadPicture(imageView: ImageView, url: String) {
        Picasso.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    companion object {

        fun create(parent: ViewGroup, clickLambda: (Article) -> Unit) =
            NewsListHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_article, parent, false
                ),
                clickLambda
            )
    }
}
