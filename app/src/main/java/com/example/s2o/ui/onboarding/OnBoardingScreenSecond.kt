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
import com.example.s2o.ui.theme.*

@Composable
fun OnBoardingScreenSecond(
    onSkip: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Skip >",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(56.dp)
                .clickable { onSkip() }
        )

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth() // Thêm cái này để Column chiếm hết chiều ngang của Card
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_card),
                    contentDescription = null,
                    tint = primary,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Thanh toán dễ dàng",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = primary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Thanh toán nhanh chóng, không cần tiền mặt.",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.Center // Căn giữa các dấu chấm trong Row
                ) {
                    Box(modifier = Modifier.size(28.dp, 8.dp).background(fourth, RoundedCornerShape(4.dp)))
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.size(28.dp, 8.dp).background(primary, RoundedCornerShape(4.dp)))
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.size(28.dp, 8.dp).background(fourth, RoundedCornerShape(4.dp)))
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = onNext,
                    colors = ButtonDefaults.buttonColors(containerColor = primary),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.height(48.dp).width(140.dp)
                ) {
                    Text(text = "Tiếp theo", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnBoardingScreenSecondDemo() {
    OnBoardingScreenSecond()
}
