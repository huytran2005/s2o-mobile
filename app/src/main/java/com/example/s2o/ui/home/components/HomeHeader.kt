package com.example.s2o.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.theme.fourth
import com.example.s2o.ui.theme.primary

@Composable
fun HomeHeader(
    onSearchClick: () -> Unit,
    onCartClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF5CB58))
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .clickable { onSearchClick() }
            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    enabled = false,
                    placeholder = { Text("Tìm kiếm") },
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(24.dp),
                    colors = TextFieldDefaults.colors(
                        disabledContainerColor = Color.White,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onCartClick,
                modifier = Modifier.background(fourth, RoundedCornerShape(12.dp))
            ) {
                Icon(Icons.Outlined.ShoppingCart, null, tint = primary)
            }

            Spacer(modifier = Modifier.width(6.dp))

            IconButton(
                onClick = onProfileClick,
                modifier = Modifier.background(fourth, RoundedCornerShape(12.dp))
            ) {
                Icon(Icons.Outlined.Person, null, tint = primary)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Chào buổi sáng", fontSize = 26.sp, color = Color.White)
        Text("Bàn số 5", fontSize = 14.sp, color = primary)
    }
}
