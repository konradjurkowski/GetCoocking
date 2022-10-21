package com.konradjurkowski.getcookingapp.feature.authentication.presentation.starting

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationService
import com.konradjurkowski.getcookingapp.util.NavigationRoutes
import com.konradjurkowski.getcookingapp.util.tools.navigator.InternalNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartingScreenViewModel @Inject constructor(
    private val authenticationService: AuthenticationService,
    private val internalNavigator: InternalNavigator
): ViewModel() {

    fun autoLogin(navController: NavController) {
        if (authenticationService.currentUser.value != null) {
            internalNavigator.goToMainScreen()
        } else {
            navController.navigate(NavigationRoutes.LOGIN) {
                popUpTo(NavigationRoutes.START) {
                    inclusive = true
                }
            }
        }
    }
}