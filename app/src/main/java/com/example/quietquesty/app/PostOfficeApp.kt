package com.example.quietquesty.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.quietquesty.navigation.PostOfficeAppRouter
import com.example.quietquesty.navigation.Screen
import com.example.quietquesty.screens.HomeScreen
import com.example.quietquesty.screens.LoginScreen
import com.example.quietquesty.screens.SignUpScreen
import com.example.quietquesty.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp(){
    Surface(modifier = Modifier.fillMaxSize(),
            color = Color.White
    ) {

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen ->{
                    TermsAndConditionsScreen()
                }
                is Screen.LoginScreen ->{
                    LoginScreen()
                }
                is Screen.HomeScreen ->{
                    HomeScreen()
                }
            }
        }
    }
}