package com.ideal.textrecognizer.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ideal.textrecognizer.R
import com.ideal.textrecognizer.TextRecognizerApp

class MainActivity : AppCompatActivity() {

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

    private val navigator = object : AppNavigator(this, R.id.fragment_container_view) {
        override fun setupFragmentTransaction(
            screen: FragmentScreen,
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment
        ) {
            //setup your animation
        }

        override fun applyCommands(commands: Array<out Command>) {
            //hideKeyboard
            super.applyCommands(commands)
        }
    }
}