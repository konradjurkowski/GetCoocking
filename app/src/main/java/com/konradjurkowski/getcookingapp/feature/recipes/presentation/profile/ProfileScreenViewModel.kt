package com.konradjurkowski.getcookingapp.feature.recipes.presentation.profile

import androidx.lifecycle.ViewModel
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationService
import com.konradjurkowski.getcookingapp.util.tools.navigator.InternalNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val authenticationService: AuthenticationService,
    private val internalNavigator: InternalNavigator
): ViewModel() {

    fun logout() {
        authenticationService.logout()
        internalNavigator.goToLoginScreen()
    }
}