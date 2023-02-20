package com.example.adabank.domain.model

enum class Currency {
    Ruble,
    Dollar,
    Euro;

    companion object {
        fun Currency.toChar() =
            when (this) {
                Ruble -> '₽'
                Dollar -> '$'
                Euro -> '€'
            }

        fun Currency.toIndicator() =
            when (this) {
                Ruble -> "RUB"
                Dollar -> "USD"
                Euro -> "EUR"
            }
    }
}