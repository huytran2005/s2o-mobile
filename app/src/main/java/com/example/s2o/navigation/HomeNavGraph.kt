package com.example.s2o.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.s2o.ui.home.HomeScreen
import com.example.s2o.ui.home.profile.ProfileScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {

    composable(Screen.Home.route) {
        HomeScreen(
            onProfileClick = {
                navController.navigate(Screen.Profile.route)
            }
        )
    }

    composable(Screen.Profile.route) {
        ProfileScreen(
            onBack = { navController.popBackStack() }
        )
    }
}
