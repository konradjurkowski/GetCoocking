package com.konradjurkowski.getcookingapp.feature.recipes.presentation.main.components

import androidx.annotation.DrawableRes
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.util.NavigationRoutes

sealed class BottomBarScreen(
    val route: String,
    @DrawableRes
    val iconRes: Int
) {
    object Home : BottomBarScreen(
        route = NavigationRoutes.HOME,
        iconRes = R.drawable.ic_home
    )
    object Favorite : BottomBarScreen(
        route = NavigationRoutes.FAVORITE,
        iconRes = R.drawable.ic_favorite
    )
    object Notification : BottomBarScreen(
        route = NavigationRoutes.NOTIFICATION,
        iconRes = R.drawable.ic_notification
    )
    object Profile : BottomBarScreen(
        route = NavigationRoutes.PROFILE,
        iconRes = R.drawable.ic_profile
    )
}