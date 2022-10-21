package com.konradjurkowski.getcookingapp.feature.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.feature.authentication.presentation.login.LoginScreen
import com.konradjurkowski.getcookingapp.feature.authentication.presentation.register.RegisterScreen
import com.konradjurkowski.getcookingapp.feature.authentication.presentation.remind_password.RemindPasswordScreen
import com.konradjurkowski.getcookingapp.feature.authentication.presentation.starting.StartingScreen
import com.konradjurkowski.getcookingapp.util.NavigationRoutes
import com.konradjurkowski.getcookingapp.util.theme.GetCookingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    override fun onPause() {
        super.onPause()
        overridePendingTransition(
            R.anim.animate_fade_enter,
            R.anim.animate_fade_exit
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetCookingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.START
                    ) {
                        composable(NavigationRoutes.START) {
                            StartingScreen(navController = navController)
                        }
                        composable(NavigationRoutes.LOGIN) {
                            LoginScreen(navController = navController)
                        }
                        composable(NavigationRoutes.REGISTER) {
                            RegisterScreen(navController = navController)
                        }
                        composable(NavigationRoutes.REMIND_PASSWORD) {
                            RemindPasswordScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
