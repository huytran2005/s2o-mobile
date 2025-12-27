package com.example.s2o.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import com.example.s2o.ui.theme.primary

@Composable
fun CategoryDetailScreen(
    categoryName: String,
    onCategoryChange: (String) -> Unit,
    onProductClick: (String) -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFF6A2B),
                RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                )
            )
    ) {
        CategorySection(
            selectedCategory = categoryName,
            onCategoryClick = onCategoryChange
        )

        // Danh sách món ăn
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(
                Color.White,
                RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                )
            ).padding(top = 4.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                FoodListItem(
                    name = "Mexican Appetizer",
                    price = "$15.00",
                    rating = "5.0",
                    description = "Tortilla Chips With Toppins",
                    imageRes = R.drawable.onboarding2,
                    onClick = { onProductClick("Mexican Appetizer") }
                )
            }

            item {
                FoodListItem(
                    name = "Pork Skewer",
                    price = "$12.99",
                    rating = "4.8",
                    description = "Marinated in a rich blend of herbs and spices, then grilled to perfection.",
                    imageRes = R.drawable.ondoarding1,
                    onClick = { onProductClick("Pork Skewer") }
                )
            }
        }
    }
}

@Composable
fun FoodListItem(
    name: String,
    price: String,
    rating: String,
    description: String,
    imageRes: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .background(primary, RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(text = "★ $rating", color = Color.White, fontSize = 12.sp)
                    }
                }
                Text(text = description, fontSize = 13.sp, color = Color.Gray)
            }
            Text(text = price, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = primary)
        }
    }
}
