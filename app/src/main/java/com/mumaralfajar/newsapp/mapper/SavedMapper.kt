package com.mumaralfajar.newsapp.mapper

import com.mumaralfajar.newsapp.database.model.NewsEntity
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.model.SourceModel
import com.mumaralfajar.newsapp.utils.interfaces.Mapper
import javax.inject.Inject

class SavedMapper @Inject constructor() : Mapper<NewsModel, NewsEntity> {

    override fun mapResponseToModel(response: NewsModel): NewsEntity {
        return NewsEntity(
            author = response.author,
            title = response.title,
            description = response.description,
            content = response.content,
            url = response.url,
            urlToImage = response.urlToImage,
            publishedAt = response.publishedAt,
            sourceId = response.sourceModel?.id ?: "",
            sourceName = response.sourceModel?.name ?: "",
        )
    }

    override fun mapModelToResponse(model: NewsEntity): NewsModel {
        return NewsModel(
            author = model.author,
            title = model.title,
            description = model.description,
            content = model.content,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            sourceModel = SourceModel(id = model.sourceId, name = model.sourceName)
        )
    }

}