package com.konradjurkowski.getcookingapp.util.tools.validator

import android.util.Patterns

class TextValidatorImpl : TextValidator {

    override fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun validatePassword(password: String): Boolean {
        return password.length >= 6
    }
}