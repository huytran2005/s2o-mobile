package com.example.s2o.ui.home.setting

import androidx.compose.foundation.background
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
import com.example.s2o.ui.theme.third

@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    var showLogout by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(third)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Outlined.ArrowBack, contentDescription = "Quay lại", tint = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Cài đặt",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        //WHITE CONTENT CARD
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            Column {
                SettingsItem(
                    icon = Icons.Outlined.Notifications,
                    title = "Cài đặt thông báo"
                )

                SettingsItem(
                    icon = Icons.Outlined.Lock,
                    title = "Cài đặt mật khẩu"
                )

                SettingsItem(
                    icon = Icons.Outlined.Person,
                    title = "Đăng xuất",
                    isLogout = true,
                    onClick = { showLogout = true }
                )
            }
        }

        //LOGOUT CONFIRM
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
