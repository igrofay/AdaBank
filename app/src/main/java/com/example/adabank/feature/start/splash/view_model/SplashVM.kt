package com.example.adabank.feature.start.splash.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature.start.splash.model.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(

): ViewModel() {
    private val _state = mutableStateOf<SplashState>(SplashState.Loading)
    val state: State<SplashState> by ::_state

    init{
        viewModelScope.launch {
            delay(2500)
            _state.value = SplashState.FirstTime
        }
    }
}