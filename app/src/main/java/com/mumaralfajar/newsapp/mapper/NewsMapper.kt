package com.mumaralfajar.newsapp.mapper

import com.mumaralfajar.newsapp.utils.interfaces.Mapper
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.model.SourceModel
import com.mumaralfajar.newsapp.response.NewsResponse
import com.mumaralfajar.newsapp.response.SourceResponse
import javax.inject.Inject

class NewsMapper @Inject constructor(
    private val sourceMapper: Mapper<SourceResponse, SourceModel>
) : Mapper<NewsResponse, NewsModel> {

    override fun mapResponseToModel(response: NewsResponse): NewsModel {
        return NewsModel(
            author = response.author ?: "",
            title = response.title ?: "",
            description = response.description ?: "",
            content = response.content ?: "",
            url = response.url ?: "",
            urlToImage = response.urlToImage ?: "",
            publishedAt = response.publishedAt ?: "",
            sourceModel = response.source?.let { sourceMapper.mapResponseToModel(it) }
        )
    }

    override fun mapModelToResponse(model: NewsModel): NewsResponse {
        return NewsResponse(
            author = model.author,
            title = model.title,
            description = model.description,
            content = model.content,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            source = model.sourceModel?.let { sourceMapper.mapModelToResponse(it) }
        )
    }

}