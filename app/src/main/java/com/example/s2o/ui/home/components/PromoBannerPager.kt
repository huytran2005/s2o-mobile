package com.example.s2o.ui.home.components

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.s2o.R
import kotlinx.coroutines.delay

@Composable
fun PromoBannerPager() {

    val banners = listOf(
        Triple(
            "Experience our\ndelicious new dish",
            "30% OFF",
            R.drawable.icon_pizza
        ),
        Triple(
            "Special lunch\ntoday only",
            "20% OFF",
            R.drawable.icon_pizza
        ),
        Triple(
            "Try our new\nchef menu",
            "40% OFF",
            R.drawable.icon_pizza
        )
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { banners.size }
    )

    // 🔁 AUTO SLIDE
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % banners.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            pageSpacing = 12.dp
        ) { page ->
            PromoBannerItem(
                title = banners[page].first,
                discount = banners[page].second,
                imageRes = banners[page].third
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        PagerIndicator(
            pageCount = banners.size,
            currentPage = pagerState.currentPage
        )
    }
}
