package com.example.s2o.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.s2o.ui.auth.AuthViewModel

@Composable
fun RootNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingFirst.route
    ) {
        onboardingNavGraph(navController)
        authNavGraph(navController, authViewModel)
        homeNavGraph(navController)
    }
}
