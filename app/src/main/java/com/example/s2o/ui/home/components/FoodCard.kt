package com.example.s2o.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoodCard(
    name: String,
    price: String
) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
    ) {

        // 🔥 IMAGE PLACEHOLDER + OVERLAY
        Box(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {



            // Price
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0xFFE95322), RoundedCornerShape(12.dp))
                    .align(Alignment.BottomEnd)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = price,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }

        //NAME
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}
