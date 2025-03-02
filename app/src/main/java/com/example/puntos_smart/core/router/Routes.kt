package com.example.puntos_smart.core.router

sealed class Screen(val route: String) {
    data object SignInSignUp : Screen("SignInSignUpScreen")
    data object AuthScreen : Screen("AuhScreen")
}
