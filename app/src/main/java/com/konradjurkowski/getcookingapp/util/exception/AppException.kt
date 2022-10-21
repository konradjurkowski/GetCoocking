package com.konradjurkowski.getcookingapp.util.exception

class AppException(message: String?): Exception(message) {

    override fun toString(): String {
        return message ?: "Unknown Exception"
    }
}