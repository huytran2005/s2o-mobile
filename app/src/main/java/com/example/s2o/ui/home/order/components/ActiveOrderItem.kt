package com.example.s2o.ui.home.order.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.R
import com.example.s2o.ui.theme.primary

@Composable
fun ActiveOrderItem(
    itemName: String,
    time: String,
    price: String,
    itemsCount: String,
    imageRes: Int,
    onCancel: () -> Unit,
    onTrack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 🍛 IMAGE
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            //INFO
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = itemName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4A2B20)
                    )
                    Text(
                        text = price,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = primary
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = time,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = itemsCount,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                //BUTTONS
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onCancel,
                        modifier = Modifier.height(36.dp).weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = primary),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("Cancel Order", fontSize = 12.sp, color = Color.White)
                    }

                    Button(
                        onClick = onTrack,
                        modifier = Modifier.height(36.dp).weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFDECDA)),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("Track Driver", fontSize = 12.sp, color = primary)
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color(0xFFF1F1F1), thickness = 1.dp)
    }
}
