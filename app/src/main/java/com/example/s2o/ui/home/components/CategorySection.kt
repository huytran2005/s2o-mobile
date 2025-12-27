package com.example.s2o.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategorySection(
    selectedCategory: String = "",
    onCategoryClick: (String) -> Unit = {}
) {
    val categories = listOf("Snacks", "Meal", "Vegan", "Dessert", "Drinks")

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(categories) {
            CategoryItem(
                title = it,
                isSelected = it == selectedCategory,
                onClick = { onCategoryClick(it) }
            )
        }
    }
}
