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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.R
import com.example.s2o.ui.home.profile.components.ProfileInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackClick: () -> Unit = {}
) {
    // STATE
    var fullName by remember { mutableStateOf("John Smith") }
    var dob by remember { mutableStateOf("09 / 10 / 1991") }
    var email by remember { mutableStateOf("johnsmith@example.com") }
    var phone by remember { mutableStateOf("+123 567 89000") }

    Scaffold(
        containerColor = Color(0xFFF5CB58),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My profile",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back",
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

            // 🔹 CARD TRẮNG (LUÔN Ở DƯỚI HEADER – RESPONSIVE)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp)
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color.White)
                    .padding(horizontal = 24.dp)
            ) {

                Spacer(modifier = Modifier.height(72.dp))

                ProfileInput("Full Name", fullName) { fullName = it }
                ProfileInput("Date of Birth", dob) { dob = it }
                ProfileInput("Email", email) { email = it }
                ProfileInput("Phone Number", phone) { phone = it }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* update profile */ },
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
                        text = "Update Profile",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))
            }

            // 🔹 AVATAR (ĐÈ LÊN CARD – KHÔNG PHỤ THUỘC MÀN HÌNH)
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 32.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_pizza),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(Color(0xFFE95322), CircleShape)
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CameraAlt,
                        contentDescription = "Change Avatar",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreen() {
    ProfileScreen()
}

