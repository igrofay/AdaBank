package com.example.adabank.feature.start.login.model

data class LoginState(
    val isSelectCodeCountry: Boolean = false,
    val codeCountry: String = "+7",
    val mobileNumber: String = "",
    val isVerificationMobileNumber: Boolean = false,
    val verificationCode: String = ""
)