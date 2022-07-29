package com.mumaralfajar.newsapp.utils.interfaces

import com.mumaralfajar.newsapp.model.NewsModel

interface Repository {

    suspend fun getHeadlineNews(): List<NewsModel>

    suspend fun getSavedNews(): List<NewsModel>

    suspend fun insertSavedNews(news: NewsModel)

    suspend fun deleteNews(news: NewsModel)

    suspend fun existNews(url: String): Boolean

}