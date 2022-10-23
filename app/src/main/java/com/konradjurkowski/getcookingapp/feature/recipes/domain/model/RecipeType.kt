package com.konradjurkowski.getcookingapp.feature.recipes.domain.model

enum class RecipeType(
    key: String
) {
    MAIN_COURSE("main_course"),
    SIDE_DISH("side dish"),
    DESSERT("dessert"),
    APPETIZER("appetizer"),
    SALAD("salad"),
    BREAD("bread"),
    BREAKFAST("breakfast"),
    SOUP("soup"),
    BEVERAGE("beverage"),
    SAUCE("sauce"),
    MARINADE("marinade"),
    FINGERFOOD("fingerfood"),
    SNACK("snack"),
    DRINK("drink")
}