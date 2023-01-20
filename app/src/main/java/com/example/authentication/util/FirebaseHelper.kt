package com.example.authentication.util

import com.example.authentication.R
import com.google.firebase.auth.FirebaseAuth

class FirebaseHelper {

    companion object {
        fun getAuth() = FirebaseAuth.getInstance()

        fun isAuthenticated() = getAuth().currentUser != null

        fun getUserId() = FirebaseAuth.getInstance().currentUser?.uid ?: ""

        fun validError(error: String?): Int {
            return when {
                error?.contains("There is no user record corresponding to this identifier") == true -> {
                    R.string.account_not_registered_register_fragment
                }
                error?.contains("The email address is badly formatted") == true -> {
                    R.string.invalid_email_register_fragment
                }
                error?.contains("The password is invalid") == true -> {
                    R.string.invalid_password_register_fragment
                }
                error?.contains("The email address is already in use by another account") == true -> {
                    R.string.email_in_use_register_fragment
                }
                error?.contains("Password should be at least 6 characters") == true -> {
                    R.string.strong_password_register_fragment
                }
                else -> {
                    R.string.error_generic
                }
            }
        }
    }

}