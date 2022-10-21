package com.konradjurkowski.getcookingapp.feature.authentication.presentation.remind_password

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.common_components.button.BasicButton
import com.konradjurkowski.getcookingapp.common_components.text_field.InputTextField
import com.konradjurkowski.getcookingapp.util.noRippleClickable
import com.konradjurkowski.getcookingapp.util.showToast

@Composable
fun RemindPasswordScreen(
    navController: NavController,
    viewModel: RemindPasswordViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val context = LocalContext.current

    val state = viewModel.state
    Scaffold(
        modifier = Modifier
            .noRippleClickable {
                focusManager.clearFocus()
            }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = screenWidth * 0.1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.remind_password),
                style = MaterialTheme.typography.h2.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(screenHeight * 0.03f))
            Text(
                text = stringResource(id = R.string.email_label),
                style = MaterialTheme.typography.h6
            )
            InputTextField(
                modifier = Modifier.fillMaxWidth(),
                text = state.email,
                onTextChange = {
                    viewModel.onEmailChange(it)
                },
                placeholder = stringResource(id = R.string.email_hint),
                keyboardType = KeyboardType.Email
            )
            AnimatedVisibility(
                visible = !state.isEmailValid
            ) {
                Text(
                    text = stringResource(id = R.string.email_not_correct),
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.error
                )
            }
            Spacer(modifier = Modifier.height(screenHeight * 0.02f))
            BasicButton(
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isLoading,
                onClick = {
                    viewModel.remindPassword(
                        onSuccess = {
                            showToast(context, context.getString(R.string.password_successfully_reset))
                            navController.popBackStack()
                        },
                        onFailure = {
                            showToast(context, it)
                        }
                    )
                }
            ) {
                Text(
                    text = stringResource(id = R.string.send_label),
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
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}