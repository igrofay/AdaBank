package com.example.adabank.feature.start.login.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adabank.feature.start.login.model.LoginEvent
import com.example.adabank.feature.start.login.view_model.LoginVM

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(
    viewModel: LoginVM = hiltViewModel()
) {
    val state by viewModel.state
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { false }
    )
    LaunchedEffect(state.isVerificationMobileNumber){
        if(state.isVerificationMobileNumber){
            modalBottomSheetState.animateTo(ModalBottomSheetValue.HalfExpanded)
        }else{
            modalBottomSheetState.hide()
        }
    }
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Box(modifier = Modifier.fillMaxSize()){
                VerificationCodeView(
                    loginState = state,
                    eventBase = viewModel
                )
            }
        },
        sheetBackgroundColor = MaterialTheme.colors.background
    ) {
        InputMobileNumberView(
            state = state,
            eventBase = viewModel,
            listCodeCountry = viewModel.listCodeCountry
        )
    }
}