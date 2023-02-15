package com.example.adabank.feature.start.splash.model

sealed class SplashState {
    object Loading: SplashState()
    object FirstTime: SplashState()
    object Registered: SplashState()
}