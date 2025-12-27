package com.example.s2o.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s2o.ui.home.history.HistoryScreen
import com.example.s2o.ui.home.cart.components.CartSheet
import com.example.s2o.ui.home.chat.ChatScreen
import com.example.s2o.ui.home.components.*
import com.example.s2o.ui.home.order.MyOrdersScreen
import com.example.s2o.ui.home.setting.SettingsScreen
import com.example.s2o.ui.theme.primary
import com.example.s2o.ui.home.components.HomeBottomBar
import com.example.s2o.ui.home.bestseller.BestSellerScreen
import com.example.s2o.ui.home.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onProfileClick: () -> Unit = {}
) {
    var mode by remember { mutableStateOf(HomeMode.HOME) }
    var showCart by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("") }
    var selectedProductName by remember { mutableStateOf("") }

    // CART
    if (showCart) {
        ModalBottomSheet(
            onDismissRequest = { showCart = false },
            containerColor = Color.Transparent
        ) {
            CartSheet(onClose = { showCart = false })
        }
    }

    // APP CONTAINER
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5CB58))
    ) {

        // HEADER (Ẩn khi ở màn hình Best Seller, Product Detail hoặc Profile)
        val showHomeHeader = mode == HomeMode.HOME || mode == HomeMode.CATEGORY_DETAIL
        if (showHomeHeader) {
            HomeHeader(
                onSearchClick = { mode = HomeMode.SEARCH },
                onCartClick = { showCart = true },
                onProfileClick = { mode = HomeMode.PROFILE },
                modifier = Modifier.statusBarsPadding()
            )
        }

        // CONTENT
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    if (mode == HomeMode.PRODUCT_DETAIL || mode == HomeMode.PROFILE || mode == HomeMode.BEST_SELLER) 
                        Color.Transparent 
                    else 
                        Color.White,
                    if (mode == HomeMode.PRODUCT_DETAIL || mode == HomeMode.PROFILE || mode == HomeMode.BEST_SELLER) 
                        RoundedCornerShape(0.dp) 
                    else 
                        RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
        ) {
            when (mode) {
                HomeMode.HOME -> HomeContent(
                    onCategoryClick = { category ->
                        selectedCategory = category
                        mode = HomeMode.CATEGORY_DETAIL
                    },
                    onViewAllBestSellerClick = {
                        mode = HomeMode.BEST_SELLER
                    }
                )

                HomeMode.CATEGORY_DETAIL -> CategoryDetailScreen(
                    categoryName = selectedCategory,
                    onCategoryChange = { category -> selectedCategory = category },
                    onProductClick = { name ->
                        selectedProductName = name
                        mode = HomeMode.PRODUCT_DETAIL
                    },
                    onBack = { mode = HomeMode.HOME }
                )

                HomeMode.BEST_SELLER -> BestSellerScreen(
                    onBack = { mode = HomeMode.HOME }
                )

                HomeMode.PRODUCT_DETAIL -> ProductDetailScreen(
                    productName = selectedProductName,
                    onBack = { mode = HomeMode.CATEGORY_DETAIL }
                )

                HomeMode.PROFILE -> ProfileScreen(
                    onBack = { mode = HomeMode.HOME }
                )

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

        //  BOTTOM BAR
        val showBottomBar = mode != HomeMode.SEARCH && mode != HomeMode.CHAT
        if (showBottomBar) {
            HomeBottomBar(
                onHomeClick = { mode = HomeMode.HOME },
                onOrdersClick = { mode = HomeMode.ORDERS },
                onChatClick = { mode = HomeMode.CHAT },
                onHistoryClick = { mode = HomeMode.HISTORY },
                onSettingsClick = { mode = HomeMode.SETTINGS },
                selectedTab = mode.name
            )
        }
    }
}

@Composable
private fun HomeContent(
    onCategoryClick: (String) -> Unit = {},
    onViewAllBestSellerClick: () -> Unit = {}
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 16.dp
        )
    ) {
        item { CategorySection(onCategoryClick = onCategoryClick) }
        item { BestSellerSection(onViewAllClick = onViewAllBestSellerClick) }

        item {
            Divider(
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
