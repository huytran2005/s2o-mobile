package com.example.s2o.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategorySection() {
    val categories = listOf("Snacks", "Meal", "Vegan", "Dessert", "Drinks")

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(categories) {
            CategoryItem(title = it)
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_7

)
@Composable
fun CategorySectionPreview() {
    CategorySection()
}
