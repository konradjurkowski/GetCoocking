package com.konradjurkowski.getcookingapp.feature.recipes.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.main.components.BottomBarScreen
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.main.components.NavigationItem

@Composable
fun MainScreen() {
    val configuration = LocalConfiguration.current
    val haptic = LocalHapticFeedback.current
    val screenHeight = configuration.screenHeightDp.dp

    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
             BottomBar(navController = bottomNavController)
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.size(screenHeight * 0.08f),
                shape = CircleShape,
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add_icon",
                    modifier = Modifier.size(screenHeight * 0.04f)
                )
            }
        }
    ) {
        MainNavigation(navController = bottomNavController)
    }
}

@Composable
private fun BottomBar(
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorite,
        BottomBarScreen.Notification,
        BottomBarScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomAppBar(
            modifier = Modifier
                .height(screenHeight * 0.12f),
            cutoutShape = CircleShape,
            backgroundColor = MaterialTheme.colors.background,
            elevation = 22.dp
        ) {
            screens.forEachIndexed { index, screen ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                NavigationItem(
                    modifier = Modifier.weight(1f),
                    iconSize = screenHeight * 0.04f,
                    iconRes = screen.iconRes,
                    isSelected = isSelected
                ) {
                    if (!isSelected) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
                if (index == 1) {
                    Box(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
