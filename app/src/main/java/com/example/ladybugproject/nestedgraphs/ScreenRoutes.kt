package com.example.ladybugproject.nestedgraphs

sealed class ScreenRoutes(val route: String){

//    Screen routes
    data object Login: ScreenRoutes("screen_login")
    data object SignUp: ScreenRoutes("screen_sign_up")
    data object Credentials: ScreenRoutes("screen_credentials")
    data object Home: ScreenRoutes("screen_home")
    data object Profile: ScreenRoutes("screen_profile")
    data object Logout: ScreenRoutes("screen_logout")

//    graph routes
    data object AuthGraph: ScreenRoutes("graph_auth")
    data object HomeGraph: ScreenRoutes("graph_home")
}