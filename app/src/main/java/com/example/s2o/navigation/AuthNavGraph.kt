package com.example.s2o.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.s2o.ui.WelcomeScreen
import com.example.s2o.ui.auth.*

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {

    composable(Screen.Welcome.route) {
        WelcomeScreen(
            onLoginClick = { navController.navigate(Screen.Login.route) },
            onSignUpClick = { navController.navigate(Screen.SignUp.route) }
        )
    }

    composable(Screen.Login.route) {
        LogInScreen(
            viewModel = authViewModel,
            onBackClick = { navController.popBackStack() },
            onSignUpClick = { navController.navigate(Screen.SignUp.route) },
            onLoginSuccess = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            }
        )
    }

    composable(Screen.SignUp.route) {
        SignUpScreen(
            viewModel = authViewModel,
            onBackClick = { navController.popBackStack() },
            onLoginClick = { navController.navigate(Screen.Login.route) }
        )
    }
}
