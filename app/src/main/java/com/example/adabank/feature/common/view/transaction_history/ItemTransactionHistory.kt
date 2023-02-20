package com.example.adabank.feature.common.view.transaction_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.domain.model.Currency.Companion.toChar
import com.example.adabank.domain.model.TransactionModel
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.click.alphaClick
import com.example.adabank.feature.common.view.click.bounceClick
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemTransactionHistory(
    model: TransactionModel<Int>,
    onClick: ()->Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .alphaClick(onClick)
    ){
        Box(
            modifier = Modifier
                .size(44.dp)
                .shadow(
                    30.dp,
                    MaterialTheme.shapes.medium,
                    ambientColor = Color(0x05051A14),
                    spotColor = Color(0x05051A14),
                )
                .background(Color.White, MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ){
            GlideImage(
                imageModel = { model.iconCategory },
                modifier = Modifier.size(26.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(),
        ){
            Text(
                text = model.category,
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onBackground,
            )
            Text(
                text = model.date,
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground.copy(0.5f),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.End,
        ){
            Text(
                text = "${model.currency.toChar()}${model.amount}",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onBackground,
            )
            Text(
                text = model.wherePaid,
                fontFamily = PoppinsFamily,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground.copy(0.5f),
            )
        }
    }
}