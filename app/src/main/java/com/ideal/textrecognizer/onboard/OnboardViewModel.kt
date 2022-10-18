package com.ideal.textrecognizer.onboard

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.ideal.textrecognizer.TextRecognizerApp
import com.ideal.textrecognizer.screens.Screens

class OnboardViewModel(private val router: Router) : ViewModel() {

    fun navigateToRecognizer(savedUri: Uri?) {
        router.navigateTo(Screens.TextRecognizer(savedUri))
    }

    @Suppress("UNCHECKED_CAST")
    companion object Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OnboardViewModel(TextRecognizerApp.INSTANCE.router) as T
        }
    }
}