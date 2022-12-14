package com.konradjurkowski.getcookingapp.feature.authentication.presentation.remind_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationService
import com.konradjurkowski.getcookingapp.util.tools.validator.TextValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RemindPasswordViewModel @Inject constructor(
    private val authenticationService: AuthenticationService,
    private val textValidator: TextValidator
) : ViewModel() {

    var state by mutableStateOf(RemindPasswordState())
        private set

    fun onEmailChange(newValue: String) {
        state = state.copy(email = newValue)
    }

    fun remindPassword(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val isEmailValid = textValidator.validateEmail(state.email.trim())
        state = state.copy(isEmailValid = isEmailValid)
        // * make remindPassword api call only when inputs are valid
        if (isEmailValid) {
            state = state.copy(isLoading = true)
            authenticationService.remindPassword(
                email = state.email,
                onSuccess = {
                    state = state.copy(isLoading = false)
                    onSuccess()
                },
                onFailure = {
                    state = state.copy(isLoading = false)
                    onFailure(it)
                }
            )
        }
    }
}