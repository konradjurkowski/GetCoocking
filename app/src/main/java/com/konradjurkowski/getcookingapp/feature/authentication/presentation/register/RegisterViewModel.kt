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
        state = state.copy(
            email = newValue
        )
    }

    fun onPasswordChange(newValue: String) {
        state = state.copy(
            password = newValue
        )
    }

    fun onRepeatedPasswordChange(newValue: String) {
        state = state.copy(
            repeatedPassword = newValue
        )
    }

    fun register(navController: NavController, onFailure: (String) -> Unit) {
        state = state.copy(isEmailValid = true, isPasswordValid = true, isPasswordsTheSame = true)
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
        if (state.password.trim() != state.repeatedPassword.trim()) {
            state = state.copy(isPasswordsTheSame = false)
            return
        }
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