package com.example.s2o.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.s2o.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun OnBoardingScreenFirst(
    onSkip: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // 🔹 Image background
        Image(
            painter = painterResource(id = R.drawable.ondoarding1), // ảnh pizza
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .height(420.dp),
            contentScale = ContentScale.Crop
        )

        // 🔹 Skip button
        Text(
            text = "Skip >",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(56.dp)
                .clickable() { onSkip() }
        )

        // 🔹 Bottom card
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Icon
                Icon(
                    painter = painterResource(id = R.drawable.ic_delivery),
                    contentDescription = null,
                    tint = Color(0xFFFF5722),
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Title
                Text(
                    text = "Đặt món ăn tại nhà hàng",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF5722)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Description
                Text(
                    text = "Chỉ vài chạm để đặt món ngon tại nhà hàng bạn yêu thích",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(24.dp))
                Row(

                ) {
                    Button(onClick = {}, modifier = Modifier.height(8.dp,).width(28.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF5722)
                    )) {
                    }
                    Button(onClick = {}, modifier = Modifier.height(8.dp,).width(28.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF5F5F5)
                    )) {
                    }
                    Button(onClick = {}, modifier = Modifier.height(8.dp,).width(28.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF5F5F5)
                    )) {
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                // Next button
                Button(
                    onClick = onNext,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF5722)
                    ),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .width(140.dp)
                ) {
                    Text(text = "Tiếp theo", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnBoardingScreenFirstDemo(){
    OnBoardingScreenFirst ()
}