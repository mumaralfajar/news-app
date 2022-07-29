package com.mumaralfajar.newsapp.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import com.mumaralfajar.newsapp.api.NewsAPI
import com.mumaralfajar.newsapp.database.dao.SavedNewsDao
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.mapper.NewsMapper
import com.mumaralfajar.newsapp.mapper.SavedMapper
import com.mumaralfajar.newsapp.utils.interfaces.Repository
import javax.inject.Inject

@ActivityRetainedScoped
class NewsRepository @Inject constructor(
    private val newsAPI: NewsAPI,
    private val savedNewsDao: SavedNewsDao,
    private val mapper: NewsMapper,
    private val savedNewsMapper: SavedMapper
) : Repository {

    override suspend fun getHeadlineNews(): List<NewsModel> {
        return newsAPI.getHeadlineNews().articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

    override suspend fun getSavedNews(): List<NewsModel> {
        return savedNewsDao.getAllNews().map {
            savedNewsMapper.mapModelToResponse(
                it
            )
        }
    }

    override suspend fun insertSavedNews(news: NewsModel) {
        savedNewsDao.insertNews(savedNewsMapper.mapResponseToModel(news))
    }

    override suspend fun deleteNews(news: NewsModel) {
        savedNewsDao.deleteNews(savedNewsMapper.mapResponseToModel(news))
    }

    override suspend fun existNews(url: String) : Boolean {
        return savedNewsDao.existNews(url)
    }

}