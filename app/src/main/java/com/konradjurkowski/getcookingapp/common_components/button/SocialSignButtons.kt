package com.konradjurkowski.getcookingapp.common_components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.util.theme.Gray4

@Composable
fun SocialSignButton(
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Gray4,
                thickness = 2.dp,
                modifier = Modifier
                    .width(50.dp)
                    .padding(end = dimensionResource(id = R.dimen.small_padding))
            )
            Text(
                text = stringResource(id = R.string.sign_in_with),
                style = MaterialTheme.typography.h6,
                color = Gray4,
            )
            Divider(
                color = Gray4,
                thickness = 2.dp,
                modifier = Modifier
                    .width(50.dp)
                    .padding(start = dimensionResource(id = R.dimen.small_padding))
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.regular_padding)))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialButton(
                onClick = onGoogleClick,
                imageRes = R.drawable.ic_google
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.regular_padding)))
            SocialButton(
                onClick = onFacebookClick,
                imageRes = R.drawable.ic_facebook
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SocialButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes
    imageRes: Int
) {
    val haptic = LocalHapticFeedback.current
    Card(
        modifier = modifier.size(dimensionResource(id = R.dimen.social_button_size)),
        onClick = {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        },
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_corner_shape_size)),
        elevation = 5.dp
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.extra_small_padding))
        )
    }
}