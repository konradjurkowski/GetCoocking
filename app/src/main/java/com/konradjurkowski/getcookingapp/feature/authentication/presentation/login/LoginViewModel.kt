package com.konradjurkowski.getcookingapp.feature.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationService
import com.konradjurkowski.getcookingapp.util.tools.navigator.InternalNavigator
import com.konradjurkowski.getcookingapp.util.tools.validator.TextValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationService: AuthenticationService,
    private val textValidator: TextValidator,
    private val internalNavigator: InternalNavigator
): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEmailChange(newValue: String) {
        state = state.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        state = state.copy(password = newValue)
    }

    fun login(onFailure: (String) -> Unit) {
        val isEmailValid = textValidator.validateEmail(state.email.trim())
        val isPasswordValid = textValidator.validatePassword(state.password.trim())
        state = state.copy(
            isEmailValid = isEmailValid,
            isPasswordValid = isPasswordValid
        )
        // * make login api call only when inputs are valid
        if (isEmailValid && isPasswordValid) {
            state = state.copy(isLoading = true)
            authenticationService.login(
                email = state.email.trim(),
                password = state.password.trim(),
                onFailure = { failureMessage ->
                    state = state.copy(isLoading = false)
                    onFailure(failureMessage)
                },
                onSuccess = {
                    state = state.copy(isLoading = false)
                    internalNavigator.goToMainScreen()
                }
            )
        }
    }
}