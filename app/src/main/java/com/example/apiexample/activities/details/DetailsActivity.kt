package com.example.apiexample.activities.details

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.apiexample.R
import com.example.apiexample.data.response.Article
import com.example.apiexample.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    companion object {

        private const val ARTICLE = "article"

        fun openDetails(activity: Activity, article: Article) =
            Intent(activity, DetailsActivity::class.java)
                .putExtra(ARTICLE,  article)
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val new = intent.getParcelableExtra<Article>(ARTICLE)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.article = new
        loadPicture(iv_cover, new.urlToImage)
    }


    private fun loadPicture(imageView: ImageView, url: String) {
        Picasso.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}
