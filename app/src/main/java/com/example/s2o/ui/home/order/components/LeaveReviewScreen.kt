package com.example.s2o.ui.home.order.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LeaveReviewScreen(
    onCancel: () -> Unit,
    onSubmit: () -> Unit
) {
    var rating by remember { mutableStateOf(0) }
    var comment by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        // IMAGE PLACEHOLDER
        Box(
            modifier = Modifier
                .size(160.dp)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(24.dp)
                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // TITLE
        Text(
            text = "Chicken Curry",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // SUBTITLE
        Text(
            text = "We'd love to know what you\nthink of your dish.",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        // STAR RATING
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 1..5) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                    tint = if (i <= rating)
                        Color(0xFFFF9800)
                    else
                        Color(0xFFFFCC80),
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { rating = i }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // COMMENT LABEL
        Text(
            text = "Leave us your comment!",
            fontSize = 14.sp,
            color = Color(0xFF7A4A3C)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // COMMENT BOX
        TextField(
            value = comment,
            onValueChange = { comment = it },
            placeholder = { Text("Write Review...") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFF3C4),
                unfocusedContainerColor = Color(0xFFFFF3C4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // ACTION BUTTONS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Cancel")
            }

            Button(
                onClick = onSubmit,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6A2A)
                )
            ) {
                Text("Submit", color = Color.White)
            }
        }
    }
}
