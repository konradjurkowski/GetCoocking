package com.konradjurkowski.getcookingapp.feature.authentication.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationService
import com.konradjurkowski.getcookingapp.util.tools.validator.TextValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authenticationService: AuthenticationService,
    private val textValidator: TextValidator
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    fun onEmailChange(newValue: String) {
        state = state.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        state = state.copy(password = newValue)
    }

    fun onRepeatedPasswordChange(newValue: String) {
        state = state.copy(repeatedPassword = newValue)
    }

    fun register(navController: NavController, onFailure: (String) -> Unit) {
        val isEmailValid = textValidator.validateEmail(state.email.trim())
        val isPasswordValid = textValidator.validatePassword(state.password.trim())
        val isPasswordsTheSame = state.password.trim() ==  state.repeatedPassword.trim()
        state = state.copy(
            isEmailValid = isEmailValid,
            isPasswordValid = isPasswordValid,
            isPasswordsTheSame = isPasswordsTheSame
        )
        // * make register api call only when inputs are valid
        if (isEmailValid && isPasswordValid && isPasswordsTheSame) {
            state = state.copy(isLoading = true)
            authenticationService.register(
                email = state.email.trim(),
                password = state.password.trim(),
                onSuccess = {
                    state = state.copy(isLoading = false)
                    authenticationService.logout()
                    navController.popBackStack()
                },
                onFailure = {
                    state = state.copy(isLoading = false)
                    onFailure(it)
                }
            )
        }
    }
}