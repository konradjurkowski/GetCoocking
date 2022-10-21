package com.konradjurkowski.getcookingapp.feature.authentication.presentation.login

data class LoginState(
    val isLoading: Boolean = false,
    val isEmailValid: Boolean = true,
    val isPasswordValid: Boolean = true,
    val email: String = "",
    val password: String = ""
)
