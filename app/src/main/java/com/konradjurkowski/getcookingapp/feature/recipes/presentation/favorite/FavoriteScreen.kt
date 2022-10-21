package com.konradjurkowski.getcookingapp.feature.recipes.presentation.favorite

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(
    navController: NavController
) {
    Log.d("TAG: ", "FAVORITE BUILD")
    Scaffold(

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Favorite Screen",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}