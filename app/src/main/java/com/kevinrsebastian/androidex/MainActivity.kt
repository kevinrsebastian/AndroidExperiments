package com.kevinrsebastian.androidex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        // Returns a SplashScreen object which can be used to customize the animation or duration.
        installSplashScreen().apply {
            // Checks continuously and if the condition is true, keep showing splash screen.
            // this.setKeepOnScreenCondition { true }
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
