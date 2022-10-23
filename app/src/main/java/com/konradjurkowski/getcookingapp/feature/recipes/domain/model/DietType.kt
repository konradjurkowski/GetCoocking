package com.konradjurkowski.getcookingapp.feature.recipes.domain.model

enum class DietType(
    key: String
) {
    GLUTEN_FREE("Gluten Free"),
    KETOGENIC("Ketogenic"),
    VEGETARIAN("Vegetarian"),
    LACTO_VEGETARIAN("Lacto-Vegetarian"),
    OVO_VEGETARIAN("Ovo-Vegetarian"),
    VEGAN("Vegan"),
    PESCETARIAN("Pescetarian"),
    PALEO("Paleo"),
    PRIMAL("Primal"),
    LOW_FOODMAP("Low FODMAP"),
    Whole30("Whole30")
}