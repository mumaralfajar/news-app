package com.mumaralfajar.newsapp.mapper

import com.mumaralfajar.newsapp.utils.interfaces.Mapper
import com.mumaralfajar.newsapp.model.SourceModel
import com.mumaralfajar.newsapp.response.SourceResponse
import javax.inject.Inject

class SourceMapper @Inject constructor() : Mapper<SourceResponse, SourceModel> {

    override fun mapResponseToModel(response: SourceResponse): SourceModel {
        return SourceModel(
            id = response.id ?: "",
            name = response.name ?: ""
        )
    }

    override fun mapModelToResponse(model: SourceModel): SourceResponse {
        return SourceResponse(
            id = model.id,
            name = model.name
        )
    }

}