package com.example.s2o.ui.home.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.theme.primary

@Composable
fun PriceSliderSection() {
    var price by remember { mutableFloatStateOf(50f) }

    Text("Giá", fontSize = 16.sp)

    Slider(
        value = price,
        onValueChange = { price = it },
        valueRange = 1f..100f,
        colors = SliderDefaults.colors(
            thumbColor = primary,
            activeTrackColor = primary
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listOf("$1", "$10", "$50", "$100+").forEach {
            Text(it, fontSize = 12.sp)
        }
    }
}
