package com.konradjurkowski.getcookingapp.feature.recipes.data.repository

import com.konradjurkowski.getcookingapp.feature.recipes.data.remote.RecipeApi
import com.konradjurkowski.getcookingapp.feature.recipes.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    private val api: RecipeApi
): RecipeRepository {
}