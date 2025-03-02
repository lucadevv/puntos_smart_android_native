package com.example.puntos_smart.core.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.puntos_smart.presentation.auth_screen.AuthScreen
import com.example.puntos_smart.presentation.signin_singup.SignInSignUpScreen


@Composable
fun AppRouter(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination =  Screen.SignInSignUp.route) {
        composable(Screen.SignInSignUp.route) { SignInSignUpScreen(navHostController) }
        composable(Screen.AuthScreen.route) { AuthScreen(navHostController) }
    }
}