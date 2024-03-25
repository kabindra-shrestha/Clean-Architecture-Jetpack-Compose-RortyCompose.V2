package com.developersancho.rortycompose.data.model.remote.episode

import com.developersancho.rortycompose.data.model.remote.base.PageInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodeResponse(
    @Json(name = "info") val pageInfo: PageInfo?,
    @Json(name = "results") val results: List<EpisodeInfo>?
)