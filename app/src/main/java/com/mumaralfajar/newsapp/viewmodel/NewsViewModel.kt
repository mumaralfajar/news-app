package com.mumaralfajar.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.mumaralfajar.newsapp.base.BaseViewModel
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.repository.NewsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : BaseViewModel() {

    init {
        fetchHeadlineNews()
    }

    private val headlineNews = MutableLiveData<List<NewsModel>>()
    val headlineNewsLiveData: LiveData<List<NewsModel>>
        get() = headlineNews

    private fun fetchHeadlineNews() = viewModelScope.launch(exceptionHandler) {
        delay(3000)
        headlineNews.value = (repository.getHeadlineNews())
    }

    fun tryAgain() {
        error.value = false
        fetchHeadlineNews()
    }

}