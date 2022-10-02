package com.ae.techsadha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private var isReady: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //regionSplashScreen API To show splash screen for sometime, replace this with any other calls
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                isReady = true
            }, 6000)
        }
        //Use content draw listeners to do initial work
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener {
            return@addOnPreDrawListener isReady
        }
        //endregion
    }
}