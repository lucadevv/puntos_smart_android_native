package com.example.puntos_smart.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.puntos_smart.core.utils.composable.CustomAppBar
import com.example.puntos_smart.core.utils.constants.AppText
import com.example.puntos_smart.ui.theme.Puntos_smartTheme


@Composable
fun RegisterScreen(
    navController: NavController
){

    Scaffold(
        topBar = {
            CustomAppBar(title = "", navController = navController )
        }
    ) {innerPadding->
        Main(modifier =
        Modifier.
        padding(innerPadding)
            .padding(horizontal = 16.dp)
        )
    }

}
@Composable
private fun Main(
    modifier: Modifier
){
     val appText = AppText()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = appText.titleRegister)
        Text(text = appText.subTitleRegister)
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun RegisterPreview(){

    Puntos_smartTheme {
        val navController = rememberNavController()
        RegisterScreen(
            navController
        )
    }
}