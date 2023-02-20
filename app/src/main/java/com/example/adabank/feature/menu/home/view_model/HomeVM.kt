package com.example.adabank.feature.menu.home.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.R
import com.example.adabank.domain.model.Currency
import com.example.adabank.domain.model.TransactionModel
import com.example.adabank.domain.model.UserModel
import com.example.adabank.feature.menu.home.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(

): ViewModel() {
    private val _state = mutableStateOf<HomeState>(HomeState.Loading)
    val state : State<HomeState> by ::_state

    private val userModel = object : UserModel{
        override val name: String
            get() = "Mariana S."
        override val imageURL: String
            get() = "https://www.interfax.ru/ftproot/photos/photostory/2021/06/11/week4_1100.jpg"
        override val totalBalance: Float
            get() = 450.49f
        override val currency: Currency
            get() = Currency.Dollar
    }

    private val transactionHistory = listOf<TransactionModel<Int>>(
        object : TransactionModel<Int>{
            override val iconCategory: Int
                get() = R.drawable.ic_camera
            override val category: String
                get() = "Equipment"
            override val date: String
                get() = "17 nov"
            override val amount: Float
                get() = 220.98f
            override val currency: Currency
                get() = Currency.Dollar
            override val wherePaid: String
                get() = "Laptop Acer aspire 5"

        },
        object : TransactionModel<Int>{
            override val iconCategory: Int
                get() = R.drawable.ic_game
            override val category: String
                get() = "Entertaiment"
            override val date: String
                get() = "17 nov"
            override val amount: Float
                get() = 160.98f
            override val currency: Currency
                get() = Currency.Dollar
            override val wherePaid: String
                get() = "Game COD"
        },
        object : TransactionModel<Int>{
            override val iconCategory: Int
                get() = R.drawable.ic_reserve
            override val category: String
                get() = "Food"
            override val date: String
                get() = "13 nov"
            override val amount: Float
                get() = 20.98f
            override val currency: Currency
                get() = Currency.Dollar
            override val wherePaid: String
                get() = "Gofood"
        },
        object : TransactionModel<Int>{
            override val iconCategory: Int
                get() = R.drawable.ic_buy
            override val category: String
                get() = "Shoping"
            override val date: String
                get() = "12 nov"
            override val amount: Float
                get() = 720.98f
            override val currency: Currency
                get() = Currency.Dollar
            override val wherePaid: String
                get() = "Plaza Mall"
        },
        object : TransactionModel<Int>{
            override val iconCategory: Int
                get() = R.drawable.ic_location
            override val category: String
                get() = "Travel"
            override val date: String
                get() = "12 nov"
            override val amount: Float
                get() = 520.98f
            override val currency: Currency
                get() = Currency.Dollar
            override val wherePaid: String
                get() = "Jogja, Indonesia"
        },
    )
    init {
        viewModelScope.launch {
            delay(2000L)
            _state.value = HomeState.Success(
                userModel,
                transactionHistory
            )
        }
    }
}