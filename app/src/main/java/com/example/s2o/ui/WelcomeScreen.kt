package com.example.s2o.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.s2o.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.theme.*


@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onBackToOnboarding: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_restaurant),
            contentDescription = "logo",
            modifier = Modifier.size(width = 200.dp, height = 260.dp)
        )
        Text("Chào mừng bạn đến với nhà hàng chúng tôi", color = Color.White, fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
        
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 20.dp)
        ) {
            Button(
                onClick = onLoginClick,
                modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = third,
                    contentColor = Color.Black
                )
            ) {
                Text("Đăng nhập", color = primary, fontSize = 24.sp)
            }
            Button(
                onClick = onSignUpClick,
                modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = second,
                    contentColor = Color.Black
                )
            ) {
                Text("Đăng ký", color = primary, fontSize = 24.sp)
            }
        }

        // Nút hỗ trợ test để quay lại Onboarding
        TextButton(
            onClick = onBackToOnboarding,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Quay lại Onboarding (Dành cho Test)", color = Color.White.copy(alpha = 0.7f))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
