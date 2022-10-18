package com.ideal.textrecognizer.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.ideal.textrecognizer.R
import com.ideal.textrecognizer.TextRecognizerApp

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fragment_container_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        TextRecognizerApp.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        TextRecognizerApp.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

}