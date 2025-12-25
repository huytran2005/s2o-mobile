package com.example.s2o.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.s2o.ui.onboarding.*

fun NavGraphBuilder.onboardingNavGraph(
    navController: NavHostController
) {

    composable(Screen.OnBoardingFirst.route) {
        OnBoardingScreenFirst(
            onNext = { navController.navigate(Screen.OnBoardingSecond.route) },
            onSkip = {
                navController.navigate(Screen.Welcome.route) {
                    popUpTo(Screen.OnBoardingFirst.route) { inclusive = true }
                }
            }
        )
    }

    composable(Screen.OnBoardingSecond.route) {
        OnBoardingScreenSecond(
            onNext = { navController.navigate(Screen.OnBoardingThird.route) },
            onSkip = {
                navController.navigate(Screen.Welcome.route) {
                    popUpTo(Screen.OnBoardingFirst.route) { inclusive = true }
                }
            }
        )
    }

    composable(Screen.OnBoardingThird.route) {
        OnBoardingScreenThird(
            onNext = {
                navController.navigate(Screen.Welcome.route) {
                    popUpTo(Screen.OnBoardingFirst.route) { inclusive = true }
                }
            },
            onSkip = {
                navController.navigate(Screen.Welcome.route) {
                    popUpTo(Screen.OnBoardingFirst.route) { inclusive = true }
                }
            }
        )
    }
}
