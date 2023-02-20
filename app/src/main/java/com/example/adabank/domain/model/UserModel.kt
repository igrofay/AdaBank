package com.example.adabank.domain.model

interface UserModel {
    val name: String
    val imageURL: String
    val totalBalance: Float
    val currency: Currency
}