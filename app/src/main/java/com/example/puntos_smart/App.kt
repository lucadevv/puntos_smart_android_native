package com.example.puntos_smart

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.puntos_smart.core.router.AppRouter
import com.example.puntos_smart.ui.theme.Puntos_smartTheme


@Composable
fun App(navHostController: NavHostController){
    Puntos_smartTheme{
        AppRouter(navHostController = navHostController)
    }
}

