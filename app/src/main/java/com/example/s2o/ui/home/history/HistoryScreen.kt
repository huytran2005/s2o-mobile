package com.example.s2o.ui.home.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.home.history.components.HistoryItem
import com.example.s2o.ui.theme.third

@Composable
fun HistoryScreen(
    onBack: () -> Unit
) {
    var showDetails by remember { mutableStateOf(false) }

    if (showDetails) {
        OrderDetailsScreen(onBack = { showDetails = false })
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(third)
        ) {
            // TOP BAR
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Outlined.ArrowBack, contentDescription = null, tint = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Lịch sử đơn hàng",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // WHITE CONTENT CARD
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color.White,
                        RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
                    .padding(top = 8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(3) {
                        HistoryItem(onDetailsClick = { showDetails = true })
                    }
                }
            }
        }
    }
}
