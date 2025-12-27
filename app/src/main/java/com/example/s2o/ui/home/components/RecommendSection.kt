package com.example.s2o.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecommendSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Gợi ý cho bạn")
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(2) {
                FoodCard("Món gợi ý $it", "$10.00")
            }
        }
    }
}
