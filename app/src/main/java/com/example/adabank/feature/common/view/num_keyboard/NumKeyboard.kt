package com.example.adabank.feature.common.view.num_keyboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.R
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.click.bounceClick

@Composable
fun NumKeyboard(
    onClick: (Char)-> Unit,
    onDelete: ()->Unit,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ){
        for (i in 0..2){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                for (y in (1+i*3)..(3+i*3)){
                    Text(
                        text = (y).toString(),
                        fontFamily = PoppinsFamily,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 22.dp)
                            .bounceClick{
                                onClick('0'+y)
                            }
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = ".",
                fontFamily = PoppinsFamily,
                fontSize = 27.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 6.dp),
                color = Color.Transparent
            )
            Text(
                text = "0",
                fontFamily = PoppinsFamily,
                fontSize = 27.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier
                    .bounceClick{
                        onClick('0')
                    }
                    .padding(vertical = 8.dp, horizontal = 22.dp)

            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_left_circle),
                contentDescription = null,
                modifier = Modifier
                    .bounceClick{
                        onDelete()
                    }
            )
        }
    }
}