package com.example.s2o.ui.home.order.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.s2o.R

@Composable
fun OrdersContent(
    tab: OrderTab,
    onTabChange: (OrderTab) -> Unit,
    onLeaveReview: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        // TABS
        Row {
            OrderTabButton("Đang chuẩn bị", tab == OrderTab.ACTIVE) {
                onTabChange(OrderTab.ACTIVE)
            }
            Spacer(modifier = Modifier.width(8.dp))
            OrderTabButton("Hoàn thành", tab == OrderTab.COMPLETED) {
                onTabChange(OrderTab.COMPLETED)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (tab == OrderTab.ACTIVE) {
                item {
                    ActiveOrderItem(
                        itemName = "Strawberry shake",
                        time = "29 Nov, 01:20 pm",
                        price = "$20.00",
                        itemsCount = "2 items",
                        imageRes = R.drawable.onboarding3,
                        onCancel = {},
                        onTrack = {}
                    )
                }
                item {
                    ActiveOrderItem(
                        itemName = "Chicken Curry",
                        time = "28 Nov, 12:30 pm",
                        price = "$50.00",
                        itemsCount = "1 item",
                        imageRes = R.drawable.ondoarding1,
                        onCancel = {},
                        onTrack = {}
                    )
                }
            } else {
                item {
                    CompletedOrderItem(
                        itemName = "Chicken Curry",
                        time = "25 Nov, 07:00 pm",
                        price = "$50.00",
                        itemsCount = "2 items",
                        imageRes = R.drawable.ondoarding1,
                        onLeaveReview = onLeaveReview,
                        onOrderAgain = {}
                    )
                }
                item {
                    CompletedOrderItem(
                        itemName = "Strawberry shake",
                        time = "24 Nov, 03:30 pm",
                        price = "$20.00",
                        itemsCount = "1 item",
                        imageRes = R.drawable.onboarding3,
                        onLeaveReview = onLeaveReview,
                        onOrderAgain = {}
                    )
                }
            }
        }
    }
}
