package com.example.s2o.navigation

sealed class Screen(val route: String) {

    // Root graph
    object Root : Screen("root")

    // Onboarding
    object OnBoardingFirst : Screen("onboarding_first")
    object OnBoardingSecond : Screen("onboarding_second")
    object OnBoardingThird : Screen("onboarding_third")

    // Auth
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object SignUp : Screen("signup")

    // Main
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Search : Screen("search")
}
