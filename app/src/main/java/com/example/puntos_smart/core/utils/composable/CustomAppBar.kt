package com.example.puntos_smart.core.utils.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
     title: String,
     navController: NavController
){

    TopAppBar(
        title = {
            Text(title)
        },
       navigationIcon = {
           IconButton(
               onClick = {}
           ) {
               IconButton(onClick = { navController.popBackStack() }) {
                   Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")
               }
           }
       }
    )
}