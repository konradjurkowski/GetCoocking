package com.konradjurkowski.getcookingapp.feature.recipes.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.favorite.FavoriteScreen
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.home.HomeScreen
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.main.components.BottomBarScreen
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.notification.NotificationScreen
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.profile.ProfileScreen

@Composable
fun MainNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomBarScreen.Favorite.route) {
            FavoriteScreen(navController)
        }
        composable(BottomBarScreen.Notification.route) {
            NotificationScreen(navController)
        }
        composable(BottomBarScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}