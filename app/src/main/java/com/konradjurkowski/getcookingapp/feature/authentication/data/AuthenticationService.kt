package com.konradjurkowski.getcookingapp.feature.authentication.data

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseUser

interface AuthenticationService {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun remindPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun logout()
    val currentUser: LiveData<FirebaseUser?>
}