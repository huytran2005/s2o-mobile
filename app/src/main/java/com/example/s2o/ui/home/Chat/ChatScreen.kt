package com.example.s2o.ui.home.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.home.chat.components.ChatInputBar
import com.example.s2o.ui.theme.primary

// MODEL
data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

// SCREEN
@Composable
fun ChatScreen(
    onBack: () -> Unit
) {
    val messages = remember {
        mutableStateListOf(
            ChatMessage("Xin chào!", true),
            ChatMessage(
                "Chào bạn, vui lòng chọn số tương ứng với nhu cầu của bạn để được hỗ trợ nhanh nhất.\n\n" +
                        "1. Quản lý đơn hàng\n" +
                        "2. Quản lý thanh toán\n" +
                        "3. Quản lý tài khoản và hồ sơ\n" +
                        "4. Theo dõi đơn hàng\n" +
                        "5. An toàn và bảo mật",
                false
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary)
            .imePadding()
    ) {

        // 🔝 HEADER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Quay lại",
                    tint = Color.White
                )
            }

            Text(
                text = "Hỗ trợ khách hàng",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }

        // WHITE CONTAINER
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                // CHAT LIST
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    reverseLayout = false
                ) {
                    items(messages) { message ->
                        ChatBubble(message)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                // INPUT BAR
                ChatInputBar(
                    onSend = { text ->
                        messages.add(ChatMessage(text, true))

                        // fake bot reply
                        messages.add(
                            ChatMessage(
                                "Cảm ơn tin nhắn của bạn. Nhân viên hỗ trợ sẽ liên hệ với bạn sớm nhất có thể 🙌",
                                false
                            )
                        )
                    }
                )
            }
        }
    }
}

// CHAT BUBBLE
@Composable
fun ChatBubble(message: ChatMessage) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isUser)
            Arrangement.End
        else
            Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (message.isUser) Color(0xFFFFF1B8) else Color(0xFFFFE4E1),
                    RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
                .widthIn(max = 260.dp)
        ) {
            Text(
                text = message.text,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}
