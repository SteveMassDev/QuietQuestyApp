package com.example.quietquesty

import android.app.Application
import com.google.firebase.FirebaseApp

class QuietQuesty: Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}