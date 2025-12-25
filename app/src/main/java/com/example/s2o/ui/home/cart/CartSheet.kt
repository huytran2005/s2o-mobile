package com.example.s2o.ui.home.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartSheet(
    onClose: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFEF5A2A),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            )
            .padding(20.dp)
    ) {

        // 🔥 HEADER
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Cart",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "You have 2 items in the cart",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ITEMS
        CartItem(
            name = "Strawberry Shake",
            price = "$20.00"
        )

        Divider(color = Color.White.copy(alpha = 0.3f))

        CartItem(
            name = "Broccoli Lasagna",
            price = "$12.00"
        )

        Spacer(modifier = Modifier.height(24.dp))

        // SUMMARY
        SummaryRow("Subtotal", "$32.00")
        SummaryRow("Tax and Fees", "$5.00")
        SummaryRow("Delivery", "$3.00")

        Divider(color = Color.White.copy(alpha = 0.4f))

        SummaryRow(
            title = "Total",
            value = "$40.00",
            bold = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // CHECKOUT
        Button(
            onClick = onClose,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFD56A)
            )
        ) {
            Text(
                text = "Checkout",
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun SummaryRow(
    title: String,
    value: String,
    bold: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = Color.White,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = value,
            color = Color.White,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}
