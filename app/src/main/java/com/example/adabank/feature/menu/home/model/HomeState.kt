package com.example.adabank.feature.menu.home.model

import com.example.adabank.domain.model.TransactionModel
import com.example.adabank.domain.model.UserModel

sealed class HomeState {
    object Loading : HomeState()
    class Success(
        val userModel: UserModel,
        val transactionHistory: List<TransactionModel<Int>>
    ) :HomeState()
}