package com.example.s2o.ui.home.order.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.s2o.R
import com.example.s2o.ui.theme.primary

@Composable
fun OrderTabButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                if (selected) primary else primary.copy(alpha = 0.2f),
                RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text,
            color = if (selected) Color.White else primary
        )
    }
}
@Composable
fun EmptyOrderState() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp), // Thêm padding để đẩy nội dung xuống dưới tab buttons
        horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa theo chiều ngang
        verticalArrangement = Arrangement.Center // Căn giữa theo chiều dọc nếu cần
    ) {
        Image(
            painter = painterResource(R.drawable.icon_empty),
            contentDescription = "Empty Order",
            modifier = Modifier.size(200.dp) // Thay scale(4f) bằng size cụ thể (ví dụ 200dp)
        )

        Spacer(modifier = Modifier.height(60.dp)) // Tăng khoảng cách vì ảnh giờ đã to thật sự

        Text(
            "You don't have any active orders at this time",
            color = primary
        )
    }
}
