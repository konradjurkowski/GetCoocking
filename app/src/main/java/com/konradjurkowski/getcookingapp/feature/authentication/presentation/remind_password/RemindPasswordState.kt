package com.konradjurkowski.getcookingapp.feature.authentication.presentation.remind_password

data class RemindPasswordState(
    val isLoading: Boolean = false,
    val email: String = "",
    val isEmailValid: Boolean = true
)
