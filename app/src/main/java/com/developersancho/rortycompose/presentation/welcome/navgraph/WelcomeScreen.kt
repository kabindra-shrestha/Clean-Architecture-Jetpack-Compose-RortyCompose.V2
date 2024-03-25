package com.developersancho.rortycompose.presentation.welcome.navgraph

sealed class WelcomeScreen(val route: String) {
    object OnBoarding : WelcomeScreen(route = "onBoarding_screen")
    object Environment : WelcomeScreen(route = "environment_screen")
}