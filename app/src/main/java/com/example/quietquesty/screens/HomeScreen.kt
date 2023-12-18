package com.example.quietquesty.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quietquesty.components.ButtonComponent
import com.example.quietquesty.components.HeadingTextComponent
import com.example.quietquesty.data.SignupViewModel

@Composable
fun HomeScreen(loginViewModel: SignupViewModel = viewModel()) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Pomodoro")

            ButtonComponent(value = "Logout", onButtonClicked = {
                loginViewModel.logout()
            }, isEnabled = true)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}