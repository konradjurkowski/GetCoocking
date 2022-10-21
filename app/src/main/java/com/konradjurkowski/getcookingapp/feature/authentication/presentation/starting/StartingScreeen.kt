package com.konradjurkowski.getcookingapp.feature.authentication.presentation.starting

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.common_components.button.BasicButton

@Composable
fun StartingScreen(
    navController: NavController,
    viewModel: StartingScreenViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        Image(
            painter = painterResource(id = R.drawable.ic_background),
            contentDescription = "background_image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = screenHeight * 0.05f,
                    bottom = screenHeight * 0.1f
                )
                .padding(
                    horizontal = dimensionResource(id = R.dimen.regular_padding)
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "app_logo",
                    modifier = Modifier
                        .size(screenHeight * 0.2f)
                )
                Text(
                    text = stringResource(id = R.string.premium_recipe_label),
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column {
                Text(
                    text = stringResource(id = R.string.get_cooking_header),
                    style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(id = R.string.app_description),
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(screenHeight * 0.1f))
                BasicButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.regular_padding)),
                    onClick = {
                        viewModel.autoLogin(navController)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.start_cooking_label),
                        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.small_padding)))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }
    }
    BackHandler(enabled = false) {
        // NO - OP
    }
}