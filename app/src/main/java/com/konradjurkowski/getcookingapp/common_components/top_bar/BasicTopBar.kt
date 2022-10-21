package com.konradjurkowski.getcookingapp.common_components.top_bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.util.vibrateClick

@Composable
fun BasicTopBar(
    title: String? = null,
    @DrawableRes
    leadingIcon: Int? = null,
    @DrawableRes
    trailingIcon: Int? = null,
    onLeadingIconClicked: () -> Unit = {},
    onTrailingIconClicked: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.regular_padding))
    ) {
        leadingIcon?.let {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = "leading_icon",
                tint = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(dimensionResource(id = R.dimen.small_padding))
                    .vibrateClick(onLeadingIconClicked)
            )
        }
        title?.let {
            Text(
                text = title,
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        trailingIcon?.let {
            Icon(
                painter = painterResource(id = trailingIcon),
                contentDescription = "trailing_icon",
                tint = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .vibrateClick(onTrailingIconClicked)
                    .padding(dimensionResource(id = R.dimen.small_padding))
            )
        }
    }
}