package com.example.adabank.domain.model


interface TransactionModel<Recurse> {
    val iconCategory: Recurse
    val category: String
    val date: String
    val amount: Float
    val currency: Currency
    val wherePaid: String
}