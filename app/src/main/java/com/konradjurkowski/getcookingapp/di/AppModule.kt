package com.konradjurkowski.getcookingapp.di

import android.app.Application
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationService
import com.konradjurkowski.getcookingapp.feature.authentication.data.AuthenticationServiceImpl
import com.konradjurkowski.getcookingapp.util.tools.StringResProvider
import com.konradjurkowski.getcookingapp.util.tools.navigator.InternalNavigator
import com.konradjurkowski.getcookingapp.util.tools.validator.TextValidator
import com.konradjurkowski.getcookingapp.util.tools.validator.TextValidatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideStringResProvider(app: Application): StringResProvider {
        return StringResProvider(app)
    }

    @Provides
    @Singleton
    fun provideAuthenticationService(stringResProvider: StringResProvider): AuthenticationService {
        return AuthenticationServiceImpl(Firebase.auth, stringResProvider)
    }

    @Provides
    fun provideInternalNavigator(app: Application): InternalNavigator {
        return InternalNavigator(app)
    }

    @Provides
    fun provideTextValidator(): TextValidator {
        return TextValidatorImpl()
    }
}