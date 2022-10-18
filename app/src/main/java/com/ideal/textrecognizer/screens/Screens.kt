package com.ideal.textrecognizer.screens

import android.net.Uri
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ideal.textrecognizer.textRecognizer.TextRecognizerFragment
import com.ideal.textrecognizer.onboard.OnboardFragment

object Screens {
    fun Onboard() = FragmentScreen {
        OnboardFragment()
    }

    fun TextRecognizer(uri : Uri?) = FragmentScreen(TextRecognizerFragment.UriKey) {
        TextRecognizerFragment(uri)
    }
}