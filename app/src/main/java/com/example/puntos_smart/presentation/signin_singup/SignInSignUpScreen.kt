package com.example.puntos_smart.presentation.signin_singup

import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.AspectRatioFrameLayout.ResizeMode
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.puntos_smart.core.router.AuthScreen
import com.example.puntos_smart.ui.theme.Puntos_smartTheme


@Composable
fun SignInSignUpScreen(
    navHostController: NavController
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black
    ) {innerPadding->
        Box(modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
        ){
            VideoBackground(url = "https://servicios.puntossmart.com/img/anuncio.mp4")
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 32.dp),


            ) {

                Text("Puntos Smart",style = MaterialTheme.typography.headlineSmall
                    .copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Vive la Experiencia Smart",style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                ))
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        navHostController.navigate(AuthScreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 32.dp)
                ) {
                    Text(
                        "Iniciar Sesion",
                        style = MaterialTheme.typography.bodyLarge
                            .copy(fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor =  MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.primary,
                    ),
                    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 32.dp)
                    ) {
                    Text("Registrarse", style = MaterialTheme.typography.bodyLarge
                        .copy(fontWeight = FontWeight.Bold)
                    )
                }

            }
        }

    }
}

@Preview
@Composable
fun HomeScreePreview(){
    val navController = rememberNavController()
    Puntos_smartTheme {
        SignInSignUpScreen(navController)
    }
}

@OptIn(UnstableApi::class)
@Composable
fun VideoBackground(url: String){
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
    }
    exoPlayer.playWhenReady = true
    exoPlayer.volume = 0f
    exoPlayer.repeatMode = ExoPlayer.REPEAT_MODE_ALL

    val mediaItem = remember {
        MediaItem.Builder()
            .setUri(Uri.parse(url))
            .build()
    }
    LaunchedEffect(url) {
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
    }
    DisposableEffect(context) {
        onDispose {
            exoPlayer.release()
        }
    }


    Box(modifier = Modifier
        .fillMaxSize()
    ){
       AndroidView(factory = {
           PlayerView(it).apply {
               player = exoPlayer
               useController= false
               resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
           }
       })
    }

}