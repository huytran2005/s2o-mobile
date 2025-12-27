package com.example.s2o.ui.home.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.R
import com.example.s2o.ui.theme.third

@Composable
fun OrderDetailsScreen(
    onBack: () -> Unit
) {
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
                text = "Chi tiết đơn hàng",
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
                .padding(horizontal = 24.dp)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Mã đơn hàng: 0054752",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4A2B20)
                    )
                    Text(
                        text = "29 Th11, 01:20 pm",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    Divider(color = Color(0xFFF1F1F1), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(24.dp))
                }

                item {
                    OrderDetailItem(
                        name = "Sinh tố dâu tây",
                        price = "$20.00",
                        time = "29/11/24\n15:00",
                        count = 3,
                        imageRes = R.drawable.onboarding3
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color(0xFFF1F1F1), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    OrderDetailItem(
                        name = "Bông cải xanh Lasagna",
                        price = "$12.00",
                        time = "29/11/24\n12:00",
                        count = 3,
                        imageRes = R.drawable.ondoarding1
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color(0xFFF1F1F1), thickness = 1.dp)
                }

                item {
                    Spacer(modifier = Modifier.height(32.dp))
                    SummaryRow("Tạm tính", "$32.00")
                    SummaryRow("Thuế và Phí", "$5.00")
                    SummaryRow("Phí vận chuyển", "$3.00")

                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(
                        color = Color(0xFFF1F1F1),
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Tổng cộng", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("$40.00", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFE0D3)),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text("Đặt lại đơn này", color = Color(0xFFE95322), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
    }
}

@Composable
fun OrderDetailItem(
    name: String,
    price: String,
    time: String,
    count: Int,
    imageRes: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(price, color = Color.Gray, fontSize = 14.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(time, fontSize = 12.sp, color = Color.Gray)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("-", color = Color(0xFFE95322), modifier = Modifier.padding(horizontal = 4.dp))
                Text(count.toString(), fontSize = 14.sp)
                Text("+", color = Color(0xFFE95322), modifier = Modifier.padding(horizontal = 4.dp))
            }
        }
    }
}

@Composable
fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Text(value, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}
