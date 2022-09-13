package com.ae.techsadha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    var isReady: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To show splash screen for sometime, replace this with any other calls
        Handler().postDelayed({
            isReady = true
        }, 6000)

        //Use content draw listeners to do initial work
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener {
            return@addOnPreDrawListener isReady
        }
    }
}