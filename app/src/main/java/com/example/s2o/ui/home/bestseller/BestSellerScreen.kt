package com.example.s2o.ui.home.bestseller

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.R
import com.example.s2o.ui.home.bestseller.components.BestSellerItem
import com.example.s2o.ui.theme.third

@Composable
fun BestSellerScreen(
    onBack: () -> Unit
) {
    val items = listOf(
        BestSellerData("Sunny Bruschetta", "$15.00", "5.0", R.drawable.onboarding2),
        BestSellerData("Gourmet Grilled Skewers", "$12.00", "4.5", R.drawable.ondoarding1),
        BestSellerData("Barbecue tacos", "$15.00", "4.0", R.drawable.onboarding2),
        BestSellerData("Broccoli lasagna", "$12.00", "3.5", R.drawable.ondoarding1),
        BestSellerData("Iced Coffee", "$15.00", "5.0", R.drawable.onboarding3),
        BestSellerData("Strawberry Cake", "$12.00", "4.8", R.drawable.onboarding3)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(third)
    ) {
        //TOP BAR
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
                text = "Bán chạy nhất",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        //CONTENT CARD
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .padding(horizontal = 16.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Khám phá các món ăn phổ biến nhất của chúng tôi!",
                    color = Color(0xFFE95322),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(items) { data ->
                        BestSellerItem(
                            name = data.name,
                            price = data.price,
                            rating = data.rating,
                            imageRes = data.imageRes
                        )
                    }
                }
            }
        }
    }
}

data class BestSellerData(
    val name: String,
    val price: String,
    val rating: String,
    val imageRes: Int
)
