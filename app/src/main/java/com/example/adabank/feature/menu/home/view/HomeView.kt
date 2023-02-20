package com.example.adabank.feature.menu.home.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature.menu.home.model.HomeState

val peekHeight = 80.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(
    state: HomeState.Success
) {
    val model = state.userModel
    BackdropScaffold(
        appBar = {
            UserAppBar(userModel = model)
        },

        backLayerContent = {
            BalanceView(userModel = model)
        },
        frontLayerContent = {
            ContentView(state)
        },
        backLayerBackgroundColor = MaterialTheme.colors.surface,
        frontLayerBackgroundColor = MaterialTheme.colors.background,
        peekHeight = peekHeight,
        frontLayerScrimColor = Color.Unspecified,
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
    )
}