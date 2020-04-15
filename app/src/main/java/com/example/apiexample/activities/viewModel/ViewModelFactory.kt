package com.example.apiexample.activities.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apiexample.activities.list.NewsListViewModel
import com.example.apiexample.api.NewsService
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelMap: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val result = viewModelMap[modelClass] ?: viewModelMap.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("Unknown model class $modelClass")
        @Suppress("UNCHECKED_CAST")
        return result.get() as T
    }
}
