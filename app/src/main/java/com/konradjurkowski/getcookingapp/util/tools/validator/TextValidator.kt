package com.konradjurkowski.getcookingapp.util.tools.validator

interface TextValidator {
    fun validateEmail(email: String): Boolean
    fun validatePassword(password: String): Boolean
}