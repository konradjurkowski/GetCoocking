package com.konradjurkowski.getcookingapp.feature.authentication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.util.tools.StringResProvider
import javax.inject.Inject

class AuthenticationServiceImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val stringResProvider: StringResProvider
): AuthenticationService {

    private val _currentUser = MutableLiveData(auth.currentUser)
    override val currentUser: LiveData<FirebaseUser?> = _currentUser

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                _currentUser.value = auth.currentUser
                onSuccess()
            }
            .addOnFailureListener {
                if (it is FirebaseAuthException) {
                    onFailure(it.message ?: stringResProvider.getString(R.string.unknown_exception_message))
                } else {
                    onFailure(stringResProvider.getString(R.string.unknown_exception_message))
                }
            }
    }

    override fun register(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                if (it is FirebaseAuthException) {
                    onFailure(it.message ?: stringResProvider.getString(R.string.unknown_exception_message))
                } else {
                    onFailure(stringResProvider.getString(R.string.unknown_exception_message))
                }
            }
    }

    override fun remindPassword(
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        auth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                if (it is FirebaseAuthException) {
                    onFailure(it.message ?: stringResProvider.getString(R.string.unknown_exception_message))
                } else {
                    onFailure(stringResProvider.getString(R.string.unknown_exception_message))
                }
            }
    }

    override fun logout() {
        auth.signOut()
        _currentUser.value = auth.currentUser
    }
}