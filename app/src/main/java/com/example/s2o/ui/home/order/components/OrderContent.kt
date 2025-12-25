package com.example.s2o.ui.home.order.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun OrdersContent(
    tab: OrderTab,
    onTabChange: (OrderTab) -> Unit,
    onLeaveReview: () -> Unit
) {
    Column {

        // TABS
        Row {
            OrderTabButton("Active", tab == OrderTab.ACTIVE) {
                onTabChange(OrderTab.ACTIVE)
            }
            Spacer(modifier = Modifier.width(8.dp))
            OrderTabButton("Completed", tab == OrderTab.COMPLETED) {
                onTabChange(OrderTab.COMPLETED)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (tab == OrderTab.ACTIVE) {
            EmptyOrderState()
        } else {
            CompletedOrderItem(
                onLeaveReview = onLeaveReview
            )
        }
    }
}
