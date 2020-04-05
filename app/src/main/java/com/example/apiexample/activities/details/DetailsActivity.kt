package com.example.apiexample.activities.details

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.apiexample.R
import com.example.apiexample.api.response.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    // И тут я поняла, что апишка только список статей может возвращать и все!

    companion object{

        private const val ARTICLE = "article"

        fun openDetails(activity: Activity, article: Article) =
            Intent(activity, DetailsActivity::class.java)
                .putExtra(ARTICLE, article)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val new = intent.getParcelableExtra<Article>(ARTICLE)
        loadPicture(iv_cover, new.urlToImage)
        binding: DetailsA = DataBidingUtil.

        }


    private fun loadPicture(imageView: ImageView, url: String) {
        Picasso.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}
