package com.konradjurkowski.getcookingapp.feature.recipes.data.remote.dto

import com.squareup.moshi.Json

data class RecipeSearchDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "image") val image: String,
    @field:Json(name = "imageType") val imageType: String,
    @field:Json(name = "title") val title: String
)