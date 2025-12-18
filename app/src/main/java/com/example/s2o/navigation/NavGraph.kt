package com.example.s2o.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.s2o.ui.WelcomeScreen
import com.example.s2o.ui.auth.LogInScreen
import com.example.s2o.ui.auth.SignUpScreen
import com.example.s2o.ui.onboarding.OnBoardingScreenFirst
import com.example.s2o.ui.onboarding.OnBoardingScreenSecond
import com.example.s2o.ui.onboarding.OnBoardingScreenThird

sealed class Screen(val route: String) {
    object OnBoardingFirst : Screen("onboarding_first")
    object OnBoardingSecond : Screen("onboarding_second")
    object OnBoardingThird : Screen("onboarding_third")
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object SignUp : Screen("signup")
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingFirst.route
    ) {
        composable(route = Screen.OnBoardingFirst.route) {
            OnBoardingScreenFirst(
                onNext = { navController.navigate(Screen.OnBoardingSecond.route) },
                onSkip = { 
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.OnBoardingFirst.route) { inclusive = true }
                    }
                }
            )
        }
        composable(route = Screen.OnBoardingSecond.route) {
            OnBoardingScreenSecond(
                onNext = { navController.navigate(Screen.OnBoardingThird.route) },
                onSkip = { 
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.OnBoardingFirst.route) { inclusive = true }
                    }
                }
            )
        }
        composable(route = Screen.OnBoardingThird.route) {
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
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                onLoginClick = { navController.navigate(Screen.Login.route) },
                onSignUpClick = { navController.navigate(Screen.SignUp.route) },
                onBackToOnboarding = {
                    navController.navigate(Screen.OnBoardingFirst.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }
        composable(route = Screen.Login.route) {
            LogInScreen(
                onBackClick = { navController.popBackStack() },
                onSignUpClick = { navController.navigate(Screen.SignUp.route) }
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                onBackClick = { navController.popBackStack() },
                onLoginClick = { navController.navigate(Screen.Login.route) }
            )
        }
    }
}
