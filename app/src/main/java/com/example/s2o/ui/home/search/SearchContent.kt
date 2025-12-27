package com.example.s2o.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.home.search.components.CategoryIconsSection
import com.example.s2o.ui.home.search.components.FilterChipsSection
import com.example.s2o.ui.home.search.components.PriceSliderSection
import com.example.s2o.ui.theme.primary
@Composable
fun SearchContent(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary)
    ) {

        //Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Tìm kiếm",
                fontSize = 20.sp,
                color = Color.White
            )
        }

        //WHITE CONTENT
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            CategoryIconsSection()
            Spacer(modifier = Modifier.height(16.dp))

            Text("Món ăn", fontSize = 16.sp)
            Divider(modifier = Modifier.padding(vertical = 8.dp))

            FilterChipsSection()
            Spacer(modifier = Modifier.height(24.dp))

            PriceSliderSection()
            Spacer(modifier = Modifier.height(32.dp))

            //APPLY BUTTON
            Button(
                onClick = {

                    onBack() // nếu muốn apply xong quay về Home
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primary
                )
            ) {
                Text(
                    text = "Lọc",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
