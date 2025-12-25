package com.example.s2o.ui.home.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.s2o.ui.theme.primary

@Composable
fun FilterChipsSection() {
    val items = listOf(
        "Sushi", "Pizza", "Chicken", "Curry",
        "Burger", "Cheese", "Fresh Prawn", "Ceviche", "Pad Thai"
    )

    var selected by remember { mutableStateOf(setOf<String>()) }

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            val isSelected = selected.contains(item)

            FilterChip(
                selected = isSelected,
                onClick = {
                    selected =
                        if (isSelected) selected - item
                        else selected + item
                },
                label = { Text(item) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = primary,
                    selectedLabelColor = Color.White
                )
            )
        }
    }
}
