package com.konradjurkowski.getcookingapp.feature.recipes.data.remote.dto

import com.squareup.moshi.Json

data class RecipeSearchResponseDto(
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "offset") val offset: Int,
    @field:Json(name = "results") val results: List<RecipeSearchDto>,
    @field:Json(name = "totalResults") val totalResults: Int
)