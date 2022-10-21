package com.konradjurkowski.getcookingapp.feature.authentication.presentation.register

data class RegisterState(
    val isLoading: Boolean = false,
    val isEmailValid: Boolean = true,
    val isPasswordValid: Boolean = true,
    val isPasswordsTheSame: Boolean = true,
    val email: String = "",
    val password: String = "",
    val repeatedPassword: String = ""
)