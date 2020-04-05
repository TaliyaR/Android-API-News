package com.example.apiexample.activities.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apiexample.activities.list.NewsListViewModel
import com.example.apiexample.api.NewsService
import java.lang.IllegalArgumentException

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(NewsListViewModel::class.java) -> {
                NewsListViewModel() as? T
                    ?: throw IllegalArgumentException("Unknown ViewModel class")
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
}