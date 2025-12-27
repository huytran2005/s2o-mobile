package com.example.s2o.ui.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeBottomBar(
    onHomeClick: () -> Unit,
    onOrdersClick: () -> Unit,
    onChatClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onSettingsClick: () -> Unit,
    selectedTab: String = "HOME"
) {
    NavigationBar(
        containerColor = Color(0xFFFF6A2B),
        tonalElevation = 8.dp
    ) {
        // Home
        NavigationBarItem(
            selected = selectedTab == "HOME",
            onClick = onHomeClick,
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White) },
            label = { Text("Trang chủ", fontSize = 10.sp, color = Color.White) },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFFF5CB58))
        )

        // Orders
        NavigationBarItem(
            selected = selectedTab == "ORDERS",
            onClick = onOrdersClick,
            icon = { Icon(Icons.Filled.ReceiptLong, contentDescription = "Orders", tint = Color.White) },
            label = { Text("Đơn hàng", fontSize = 10.sp, color = Color.White) },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFFF5CB58))
        )

        // Chat
        NavigationBarItem(
            selected = selectedTab == "CHAT",
            onClick = onChatClick,
            icon = { Icon(Icons.Filled.Chat, contentDescription = "Chat", tint = Color.White) },
            label = { Text("Chat", fontSize = 10.sp, color = Color.White) },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFFF5CB58))
        )

        // History
        NavigationBarItem(
            selected = selectedTab == "HISTORY",
            onClick = onHistoryClick,
            icon = { Icon(Icons.Filled.History, contentDescription = "History", tint = Color.White) },
            label = { Text("Lịch sử", fontSize = 10.sp, color = Color.White) },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFFF5CB58))
        )

        // Settings
        NavigationBarItem(
            selected = selectedTab == "SETTINGS",
            onClick = onSettingsClick,
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = Color.White) },
            label = { Text("Cài đặt", fontSize = 10.sp, color = Color.White) },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFFF5CB58))
        )
    }
}
