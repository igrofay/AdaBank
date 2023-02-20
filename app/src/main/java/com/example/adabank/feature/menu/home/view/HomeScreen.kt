package com.example.adabank.feature.menu.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adabank.feature.common.theme.white
import com.example.adabank.feature.menu.home.model.HomeState
import com.example.adabank.feature.menu.home.view_model.HomeVM


@Composable
fun HomeScreen(
    viewModel: HomeVM = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ){
        when(
            val state = viewModel.state.value
        ){
            HomeState.Loading ->{
                CircularProgressIndicator(color = white)
            }
            is HomeState.Success -> {
                HomeView(state = state)
            }
        }
    }
}