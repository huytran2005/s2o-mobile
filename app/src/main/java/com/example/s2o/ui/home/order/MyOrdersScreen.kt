package com.example.s2o.ui.home.order

import com.example.s2o.ui.home.order.components.OrdersContent
import com.example.s2o.ui.home.order.components.LeaveReviewScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.home.order.components.EmptyOrderState
import com.example.s2o.ui.home.order.components.OrderMode
import com.example.s2o.ui.home.order.components.OrderTab
import com.example.s2o.ui.home.order.components.OrderTabButton
import com.example.s2o.ui.theme.third
@Composable
fun MyOrdersScreen(
    onBack: () -> Unit
) {
    var tab by remember { mutableStateOf(OrderTab.ACTIVE) }
    var mode by remember { mutableStateOf(OrderMode.LIST) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(third)
    ) {

        // 🔥 TOP BAR
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    if (mode == OrderMode.REVIEW) {
                        mode = OrderMode.LIST
                    } else {
                        onBack()
                    }
                }
            ) {
                Icon(Icons.Outlined.ArrowBack, null, tint = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = if (mode == OrderMode.REVIEW) "Leave a Review" else "My Orders",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        // 🔥 WHITE CONTENT
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .padding(16.dp)
        ) {
            when (mode) {
                OrderMode.LIST -> {
                    OrdersContent(
                        tab = tab,
                        onTabChange = { tab = it },
                        onLeaveReview = {
                            mode = OrderMode.REVIEW
                        }
                    )
                }

                OrderMode.REVIEW -> {
                    LeaveReviewScreen(
                        onCancel = { mode = OrderMode.LIST },
                        onSubmit = {
                            mode = OrderMode.LIST
                        }
                    )
                }
            }
        }
    }
}

