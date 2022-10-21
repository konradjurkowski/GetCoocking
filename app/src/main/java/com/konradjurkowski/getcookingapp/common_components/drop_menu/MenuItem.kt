package com.konradjurkowski.getcookingapp.common_components.drop_menu

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val text: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)
