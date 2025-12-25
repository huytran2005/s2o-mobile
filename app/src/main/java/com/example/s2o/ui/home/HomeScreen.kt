package com.example.s2o.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.s2o.ui.home.history.HistoryScreen
import com.example.s2o.ui.home.cart.components.CartSheet
import com.example.s2o.ui.home.chat.ChatScreen
import com.example.s2o.ui.home.components.*
import com.example.s2o.ui.home.order.MyOrdersScreen
import com.example.s2o.ui.home.setting.SettingsScreen
import com.example.s2o.ui.theme.primary
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onProfileClick: () -> Unit
) {
    var mode by remember { mutableStateOf(HomeMode.HOME) }
    var showCart by remember { mutableStateOf(false) }

    // CART
    if (showCart) {
        ModalBottomSheet(
            onDismissRequest = { showCart = false },
            containerColor = Color.Transparent
        ) {
            CartSheet(onClose = { showCart = false })
        }
    }

    // 🌟 NỀN VÀNG
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5CB58))
    ) {

        // HEADER
        if (mode == HomeMode.HOME) {
            HomeHeader(
                onSearchClick = { mode = HomeMode.SEARCH },
                onCartClick = { showCart = true },
                onProfileClick = onProfileClick,
                modifier = Modifier.statusBarsPadding()
            )
        }

        // 🔥 CONTENT + CARD TRẮNG (CHỈ CHIẾM PHẦN GIỮA)
        Box(
            modifier = Modifier
                .weight(1f) // 👈 CHÌA KHÓA
                .background(
                    Color.White,
                    RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp
                    )
                )
        ) {
            when (mode) {
                HomeMode.HOME -> HomeContent()

                HomeMode.SEARCH -> SearchContent {
                    mode = HomeMode.HOME
                }

                HomeMode.ORDERS -> MyOrdersScreen {
                    mode = HomeMode.HOME
                }

                HomeMode.HISTORY -> HistoryScreen {
                    mode = HomeMode.HOME
                }

                HomeMode.SETTINGS -> SettingsScreen {
                    mode = HomeMode.HOME
                }

                HomeMode.CHAT -> ChatScreen(
                    onBack = { mode = HomeMode.HOME }
                )
            }



        }

        // ✅ BOTTOM BAR (LUÔN HIỆN Ở HOME)
        if (mode == HomeMode.HOME) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White) // 👈 LỚP CHẮN
            ) {
                HomeBottomBar(
                    onHomeClick = { mode = HomeMode.HOME },
                    onOrdersClick = { mode = HomeMode.ORDERS },
                    onChatClick = {mode = HomeMode.CHAT },
                    onHistoryClick = { mode = HomeMode.HISTORY },
                    onSettingsClick = { mode = HomeMode.SETTINGS }
                )

            }

        }
    }
}

@Composable
private fun HomeContent() {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 80.dp // chừa cho bottom bar
        )
    ) {
        item { CategorySection() }
        item { BestSellerSection() }

        item {
            androidx.compose.material3.Divider(
                modifier = Modifier.padding(horizontal = 40.dp),
                thickness = 1.dp,
                color = primary.copy(alpha = 0.4f)
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { PromoBannerPager() }
        item { RecommendSection() }
    }
}
