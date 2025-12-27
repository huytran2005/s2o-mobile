package com.example.s2o.ui.home.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.R
import com.example.s2o.ui.home.profile.components.ProfileInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBack: () -> Unit = {}
) {
    // STATE
    var fullName by remember { mutableStateOf("Nguyễn Văn A") }
    var dob by remember { mutableStateOf("01 / 01 / 1995") }
    var email by remember { mutableStateOf("nguyenvana@gmail.com") }
    var phone by remember { mutableStateOf("0901234567") }

    Scaffold(
        containerColor = Color(0xFFF5CB58),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Hồ sơ của tôi",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF5CB58)
                )
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            // 🔹 CARD TRẮNG
            Column(
                modifier = Modifier
                    .fillMaxWidth().fillMaxHeight()
                    .padding(top = 64.dp)
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color.White)
                    .padding(horizontal = 24.dp)
            ) {

                Spacer(modifier = Modifier.height(72.dp))

                ProfileInput("Họ và Tên", fullName) { fullName = it }
                ProfileInput("Ngày sinh", dob) { dob = it }
                ProfileInput("Email", email) { email = it }
                ProfileInput("Số điện thoại", phone) { phone = it }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { /* cập nhật hồ sơ */ },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(44.dp),
                    shape = RoundedCornerShape(22.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE95322)
                    ),
                    contentPadding = PaddingValues(horizontal = 32.dp)
                ) {
                    Text(
                        text = "Cập nhật hồ sơ",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}
