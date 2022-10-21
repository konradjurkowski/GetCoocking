package com.konradjurkowski.getcookingapp.common_components.drop_menu

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import com.konradjurkowski.getcookingapp.R

@Composable
fun BasicDropdownMenu(
    modifier: Modifier = Modifier,
    isMenuVisible: Boolean = false,
    onDismissPressed: () -> Unit,
    menuItems: List<MenuItem>
) {
    DropdownMenu(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.small_padding)),
        expanded = isMenuVisible,
        onDismissRequest = onDismissPressed
    ) {
        menuItems.forEach { item ->
            BasicDropdownMenuItem(
                text = item.text,
                icon = item.icon,
                onClick = item.onClick
            )
        }
    }
}

@Composable
fun BasicDropdownMenuItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        modifier = modifier,
        onClick = onClick
    ) {
        Row {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.small_padding)))
            Text(
                text = text,
                style = MaterialTheme.typography.h6
            )
        }
    }
}