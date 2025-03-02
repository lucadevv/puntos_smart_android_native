package com.example.puntos_smart.presentation.login

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.puntos_smart.ui.theme.Puntos_smartTheme


@Composable
fun LoginScreen(navController: NavController){
    Scaffold(
        topBar = {
            AppBar(navController)
        }
    ) { innerPadding->
        MainScreen(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    navController: NavController
){
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")
            }
        }
    )
}
@Composable
private fun MainScreen(
    modifier: Modifier
){

    var password by remember { mutableStateOf("") }
    Column(
        modifier = modifier
    ) {
        Text(
            "Ingresa tus credenciales para continuar",
            style = MaterialTheme
                .typography
                .headlineSmall
                .copy(
                    fontWeight = FontWeight.Bold
                )
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text("Ingrese contraseña")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "password")
            },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedContainerColor =  MaterialTheme.colorScheme.onPrimary,
                focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                focusedIndicatorColor =  MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor =  Color.Gray,
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                unfocusedLeadingIconColor = Color.Gray,
            ),
            value = password,
            onValueChange = {
                password = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
        ) {
            Text(
                "Iniciar Sesión",
                 style = MaterialTheme.typography.bodyLarge
                    .copy(fontWeight = FontWeight.Bold)
                )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview(){
    Puntos_smartTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}