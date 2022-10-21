package com.konradjurkowski.getcookingapp.util.tools.navigator

import android.content.Context
import android.content.Intent
import com.konradjurkowski.getcookingapp.feature.authentication.LoginActivity
import com.konradjurkowski.getcookingapp.feature.recipes.MainActivity

class InternalNavigator(
    private val context: Context
) {

    fun goToLoginScreen() {
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun goToMainScreen() {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}