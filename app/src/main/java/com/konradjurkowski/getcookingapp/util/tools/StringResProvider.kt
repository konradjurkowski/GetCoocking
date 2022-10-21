package com.konradjurkowski.getcookingapp.util.tools

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

class StringResProvider @Inject constructor(
    private val context: Context
) {

    fun getString(
        @StringRes
        stringRes: Int
    ): String {
        return context.getString(stringRes)
    }
}