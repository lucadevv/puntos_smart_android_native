package com.example.puntos_smart.presentation.auth_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.puntos_smart.ui.theme.Puntos_smartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(navController: NavController){
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by remember { mutableStateOf("") }
    Scaffold(
       topBar = {
          TopAppBar(
              title = {},
              navigationIcon = {
                  IconButton(onClick = { navController.popBackStack() }) {
                      Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")
                  }
              }
          )
       }
    ) { innerPadding->
        Column(

            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .pointerInput(Unit){
                    detectTapGestures(
                        onTap = {
                            focusManager.clearFocus()
                            keyboardController?.hide()
                        }
                    )
                }

        ) {
            Text(
                "Ingrese su número de celular",
            style = MaterialTheme.typography.headlineSmall
                .copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Por favor, ingresa número de celular para confirmar tu identidad",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .fillMaxWidth(),

                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Call, contentDescription = "call")
                },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        IconButton(onClick = {
                            text = ""
                        }) {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "delete")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }),
                placeholder = {
                    Text("Número de celular")
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
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 32.dp)
            ) {
                Text("Siguiente")
            }
        }

    }
}
@Preview(showSystemUi = true, showBackground = false)
@Composable
private fun AuthScreenPreview(){
Puntos_smartTheme {
    val navController = rememberNavController()
    AuthScreen(navController)
}
}