package com.example.s2o.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.s2o.ui.theme.primary
@Composable
fun HomeBottomBar(
    onHomeClick: () -> Unit,
    onOrdersClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onChatClick: () -> Unit


    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(primary)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.clickable { onHomeClick() }
        )

        Icon(
            imageVector = Icons.Outlined.RoomService,
            contentDescription = "Orders",
            tint = Color.White,
            modifier = Modifier.clickable { onOrdersClick() }
        )

        Icon(
            imageVector = Icons.Outlined.Chat,
            contentDescription = "Chat",
            tint = Color.White,
            modifier = Modifier.clickable { onChatClick() }
        )


        Icon(
            imageVector = Icons.Outlined.ReceiptLong,
            contentDescription = "Receipt",
            tint = Color.White,
            modifier = Modifier.clickable { onHistoryClick() }
        )

        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = "Settings",
            tint = Color.White ,
            modifier = Modifier.clickable { onSettingsClick() }

        )
    }
}
