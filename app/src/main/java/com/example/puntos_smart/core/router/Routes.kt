package com.example.puntos_smart.core.router

import kotlinx.serialization.Serializable

sealed class Screen(val route: String) {
    data object SignInSignUp : Screen("SignInSignUpScreen")
    data object AuthScreen : Screen("AuhScreen")
}

@Serializable
object SignInSignUpScreen
@Serializable
object AuthScreen
