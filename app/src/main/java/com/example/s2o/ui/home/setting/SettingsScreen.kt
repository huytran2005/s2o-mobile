package com.example.s2o.ui.home.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.home.setting.components.LogoutConfirm
import com.example.s2o.ui.home.setting.components.SettingsItem
@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    var showLogout by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5CB58))
            . padding(top=24.dp)
    ) {

        // 🔶 HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = null,
                tint = Color(0xFFFF6F00),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBack() }
            )

            Text(
                text = "Settings",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // ⬜ CARD TRẮNG ĐÈ LÊN
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp, start = 16.dp, end = 16.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(24.dp)
                )
                .padding(vertical = 8.dp)
        ) {

            SettingsItem(
                icon = Icons.Outlined.Notifications,
                title = "Notification Setting"
            )

            SettingsItem(
                icon = Icons.Outlined.Lock,
                title = "Password Setting"
            )

            SettingsItem(
                icon = Icons.Outlined.Person,
                title = "Logout",
                isLogout = true,
                onClick = { showLogout = true }
            )
        }

        // 🔴 LOGOUT CONFIRM
        if (showLogout) {
            LogoutConfirm(
                onCancel = { showLogout = false },
                onConfirm = {
                    showLogout = false
                    // TODO logout
                }
            )
        }
    }
}
