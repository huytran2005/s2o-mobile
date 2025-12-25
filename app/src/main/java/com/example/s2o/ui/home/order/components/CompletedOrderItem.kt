package com.example.s2o.ui.home.order.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.theme.primary

@Composable
fun CompletedOrderItem(
    onLeaveReview: () -> Unit,
    onOrderAgain: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            // 🍛 IMAGE
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray)
            ) {
                // TODO: AsyncImage sau
            }

            Spacer(modifier = Modifier.width(12.dp))

            // 📄 INFO
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Chicken Curry",
                        fontSize = 16.sp
                    )
                    Text(
                        text = "$50.00",
                        fontSize = 16.sp,
                        color = primary
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "29 Nov, 01:20 pm",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "2 items",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "✓ Order delivered",
                    fontSize = 12.sp,
                    color = primary
                )

                Spacer(modifier = Modifier.height(12.dp))

                // 🔘 BUTTONS
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onLeaveReview,
                        shape = RoundedCornerShape(20.dp),
                        contentPadding = PaddingValues(
                            horizontal = 16.dp,
                            vertical = 6.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primary
                        )
                    ) {
                        Text("Leave a review", fontSize = 12.sp)
                    }


                }
            }
        }

        Divider(
            modifier = Modifier.padding(top = 16.dp),
            color = primary.copy(alpha = 0.2f)
        )
    }
}
