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
        state = state.copy(
            email = newValue
        )
    }

    fun onPasswordChange(newValue: String) {
        state = state.copy(
            password = newValue
        )
    }

    fun login(onFailure: (String) -> Unit) {
        state = state.copy(isEmailValid = true, isPasswordValid = true)
        val isEmailValid = textValidator.validateEmail(state.email.trim())
        val isPasswordValid = textValidator.validatePassword(state.password.trim())
        if (!isPasswordValid && !isEmailValid) {
            state = state.copy(isEmailValid = false, isPasswordValid = false)
            return
        }
        if (!isEmailValid) {
            state = state.copy(isEmailValid = isEmailValid)
            return
        }
        if (!isPasswordValid) {
            state = state.copy(isPasswordValid = false)
            return
        }
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