package com.konradjurkowski.getcookingapp.feature.recipes.data.remote

import com.konradjurkowski.getcookingapp.feature.recipes.data.remote.dto.RecipeSearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    companion object {
        const val API_KEY = "9bc4dddaacf340cca0a307cf75c1168f"
        const val BASE_URL = "https://api.spoonacular.com/recipes"
    }

    @GET("/complexSearch")
    fun searchRecipes(
        @Query("query") query: String,
        @Query("type") mealType: String,
        @Query("diet") diet: String,
        @Query("number") pageSize: Int = 30,
        @Query("offset") offset: Int = 0,
        @Query("apiKey") apiKey: String = API_KEY
    ): RecipeSearchResponseDto

    @GET("/random")
    // TODO SET THE RETURN TYPE
    fun getRandomRecipe(
        @Query("apiKey") apiKey: String = API_KEY
    )
}