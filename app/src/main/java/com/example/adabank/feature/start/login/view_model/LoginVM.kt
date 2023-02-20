package com.example.adabank.feature.start.login.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.adabank.feature.common.view_model.EventBase
import com.example.adabank.feature.start.login.model.LoginEvent
import com.example.adabank.feature.start.login.model.LoginState
import com.example.adabank.feature.start.login.view.LoginScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(

) : ViewModel(), EventBase<LoginEvent> {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> by ::_state
    val listCodeCountry = listOf("+7", "+62", "+1")
    override fun onEvent(event: LoginEvent) {
        when(event){
            is LoginEvent.ChangeCodeCountry -> {
                val code = listCodeCountry[event.index]
                _state.value = _state.value.copy(
                    isSelectCodeCountry = false,
                    codeCountry = code
                )
            }
            is LoginEvent.ShowListCodeCountry -> {
                _state.value = _state.value.copy(
                    isSelectCodeCountry = event.isShow,
                )
            }
            is LoginEvent.InputNumber -> {
                val loginState = _state.value
                val mobileNumber = loginState.mobileNumber + event.num
                if(mobileNumber.length>16) return
                _state.value = loginState.copy(
                    mobileNumber =mobileNumber
                )
            }
            LoginEvent.DeleteLeftNumFromMobileNumber -> {
                val loginState = _state.value
                val size = loginState.mobileNumber.length-1
                if (size<0) return
                _state.value = loginState.copy(
                    mobileNumber = loginState.mobileNumber
                        .take(size)
                )
            }
            LoginEvent.VerificationMobileNumber -> {
                _state.value = _state.value.copy(
                    isVerificationMobileNumber = true
                )
            }
            LoginEvent.CloseVerificationMobileNumber -> {
                _state.value = _state.value.copy(
                    isVerificationMobileNumber = false
                )
            }
        }
    }
}