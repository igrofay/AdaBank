package com.example.adabank.feature.start.login.model

sealed class LoginEvent {
    class ChangeCodeCountry(val index: Int):LoginEvent()
    class ShowListCodeCountry(val isShow:Boolean):LoginEvent()
    class InputNumber(val num: Char):LoginEvent()
    object DeleteLeftNumFromMobileNumber : LoginEvent()
    object VerificationMobileNumber: LoginEvent()
    object CloseVerificationMobileNumber: LoginEvent()
}