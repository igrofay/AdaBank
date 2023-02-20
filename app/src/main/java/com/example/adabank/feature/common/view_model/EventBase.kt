package com.example.adabank.feature.common.view_model

interface EventBase<T> {
    fun onEvent(event: T)
}