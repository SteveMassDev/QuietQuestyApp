package com.example.quietquesty.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quietquesty.R
import com.example.quietquesty.components.ButtonComponent
import com.example.quietquesty.components.CheckboxComponent
import com.example.quietquesty.components.ClickableLoginTextComponent
import com.example.quietquesty.components.DividerTextComponent
import com.example.quietquesty.components.HeadingTextComponent
import com.example.quietquesty.components.MyTextField
import com.example.quietquesty.components.NormalTextComponent
import com.example.quietquesty.components.PasswordTextFieldComponent
import com.example.quietquesty.components.UnderLinedTextComponent
import com.example.quietquesty.data.LoginUIEvent
import com.example.quietquesty.data.LoginViewModel
import com.example.quietquesty.data.SignupUIEvent
import com.example.quietquesty.navigation.PostOfficeAppRouter
import com.example.quietquesty.navigation.Screen
import com.example.quietquesty.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column {

                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))
                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.message),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    }, errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.ico_lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    }, errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(30.dp))
                UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))

                Spacer(modifier = Modifier.height(30.dp))
                ButtonComponent(value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },isEnabled = loginViewModel.allValidationsPassed.value)

                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false,onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
                })
            }

        }

        if(loginViewModel.loginInProcess.value) {
            CircularProgressIndicator()
        }
    }


    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}