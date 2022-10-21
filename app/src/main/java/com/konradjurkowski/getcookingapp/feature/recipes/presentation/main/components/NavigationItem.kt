package com.konradjurkowski.getcookingapp.feature.recipes.presentation.main.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.konradjurkowski.getcookingapp.util.theme.Gray4
import com.konradjurkowski.getcookingapp.util.vibrateClick

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    iconSize: Dp,
    @DrawableRes
    iconRes: Int,
    isSelected: Boolean = false,
    onItemClick: () -> Unit,
) {
    Icon(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        tint = if (isSelected) MaterialTheme.colors.primary else Gray4,
        modifier = modifier
            .size(iconSize)
            .vibrateClick(onClick = onItemClick),
    )
}