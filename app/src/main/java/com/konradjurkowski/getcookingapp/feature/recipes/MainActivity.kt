package com.konradjurkowski.getcookingapp.feature.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.feature.recipes.presentation.main.MainScreen
import com.konradjurkowski.getcookingapp.util.theme.GetCookingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
                    MainScreen()
                }
            }
        }
    }
}