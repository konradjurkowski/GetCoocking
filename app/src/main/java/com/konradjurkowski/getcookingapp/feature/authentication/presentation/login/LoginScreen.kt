package com.konradjurkowski.getcookingapp.feature.authentication.presentation.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.common_components.button.BasicButton
import com.konradjurkowski.getcookingapp.common_components.button.SocialSignButton
import com.konradjurkowski.getcookingapp.common_components.text_field.InputTextField
import com.konradjurkowski.getcookingapp.util.NavigationRoutes
import com.konradjurkowski.getcookingapp.util.noRippleClickable
import com.konradjurkowski.getcookingapp.util.showToast
import com.konradjurkowski.getcookingapp.util.vibrateClick

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = screenWidth * 0.1f),
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.login_header),
                    style = MaterialTheme.typography.h2.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = stringResource(id = R.string.login_header_part_two),
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(screenHeight * 0.05f))
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
                Spacer(modifier = Modifier.height(screenHeight * 0.03f))
                Text(
                    text = stringResource(id = R.string.password_label),
                    style = MaterialTheme.typography.h6
                )
                InputTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.password,
                    onTextChange = {
                        viewModel.onPasswordChange(it)
                    },
                    placeholder = stringResource(id = R.string.password_hint),
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation()
                )
                AnimatedVisibility(
                    visible = !state.isPasswordValid
                ) {
                    Text(
                        text = stringResource(id = R.string.password_not_correct),
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.error
                    )
                }
                Spacer(modifier = Modifier.height(screenHeight * 0.02f))
                Text(
                    text = stringResource(id = R.string.forgot_password_label),
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .vibrateClick {
                            navController.navigate(NavigationRoutes.REMIND_PASSWORD)
                        }
                )
                Spacer(modifier = Modifier.height(screenHeight * 0.02f))
                BasicButton(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !state.isLoading,
                    onClick = {
                        viewModel.login {
                            showToast(context, it)
                        }
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in_label),
                        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.small_padding)))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
                Spacer(modifier = Modifier.height(screenHeight * 0.02f))
                SocialSignButton(
                    onGoogleClick = {
                        // TODO: LOGIN WITH GOOGLE
                    },
                    onFacebookClick = {
                        // TODO: LOGIN WITH FACEBOOK
                    }
                )
                Spacer(modifier = Modifier.height(screenHeight * 0.05f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.no_account_label),
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                        color = Color.Black
                    )
                    Text(
                        text = stringResource(id = R.string.sign_up_label),
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .vibrateClick {
                                navController.navigate(NavigationRoutes.REGISTER)
                            }
                    )
                }
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