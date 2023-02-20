package com.example.adabank.feature.menu.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.button.VerticalIconButton
import com.example.adabank.R
import com.example.adabank.feature.common.view.transaction_history.ItemTransactionHistory
import com.example.adabank.feature.menu.home.model.HomeState

@Composable
fun ContentView(
    state: HomeState.Success,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = 12.dp),
    ) {
        Spacer(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(20.dp)
                .height(2.dp)
                .background(
                    MaterialTheme.colors.onBackground.copy(0.1f)
                )
        )
        Text(
            text = "Send Again",
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 15.sp,
            color =  MaterialTheme.colors.onBackground.copy(0.5f),
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.W500,
        )
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ){
            VerticalIconButton(
                image = R.drawable.im_ojaman,
                label = "Ojaman",
                isIcon = false,
                textColor = MaterialTheme.colors.onBackground,
                shape = MaterialTheme.shapes.medium,
            ){

            }
            VerticalIconButton(
                image = R.drawable.im_mariana,
                label = "Mariana",
                isIcon = false,
                textColor = MaterialTheme.colors.onBackground,
                shape = MaterialTheme.shapes.medium,
            ){

            }
            VerticalIconButton(
                image = R.drawable.im_jimanti,
                label = "Jimanti",
                isIcon = false,
                textColor = MaterialTheme.colors.onBackground,
                shape = MaterialTheme.shapes.medium,
            ){

            }
            VerticalIconButton(
                image = R.drawable.im_jumin,
                label = "Jumin",
                isIcon = false,
                textColor = MaterialTheme.colors.onBackground,
                shape = MaterialTheme.shapes.medium,
            ){

            }
        }
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "Transaction History",
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 15.sp,
            color =  MaterialTheme.colors.onBackground.copy(0.5f),
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.W500,
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            for(item in state.transactionHistory){
                ItemTransactionHistory(model = item) {

                }
            }
        }
    }
}