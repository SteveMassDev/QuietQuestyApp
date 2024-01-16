package com.example.quietquesty.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginView: ViewModel(){
    private val TAG = SignupViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProcess = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when(event){
            is LoginUIEvent.EmailChanged -> {

            }
            is LoginUIEvent.PasswordChanged -> {

            }
            is LoginUIEvent.LoginButtonClicked -> {

            }
        }
    }
}