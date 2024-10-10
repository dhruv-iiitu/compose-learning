package com.example.ladybugproject.nestedgraphs

import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.ladybugproject.nestedgraphs.screens.CredentialsScreen
import com.example.ladybugproject.nestedgraphs.screens.HomeScreen
import com.example.ladybugproject.nestedgraphs.screens.LoginScreen
import com.example.ladybugproject.nestedgraphs.screens.LogoutScreen
import com.example.ladybugproject.nestedgraphs.screens.ProfileScreen
import com.example.ladybugproject.nestedgraphs.screens.SignupScreen
import com.example.ladybugproject.ui.theme.ScreenRoutes

@Composable
fun AppNavigationGraph(modifier: Modifier = Modifier,startDestination: String = ScreenRoutes.AuthGraph.route) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = startDestination,
        enterTransition = { fadeIn(animationSpec = tween(2000)) },
        exitTransition = {
            ExitTransition.None
        }
    )
    {
        navigation(
            startDestination = ScreenRoutes.SignUp.route,
            route = ScreenRoutes.AuthGraph.route
        ) {
            composable(route = ScreenRoutes.Login.route) {
                LoginScreen(modifier) {
                    navController.navigate(ScreenRoutes.Home.route) {
                        popUpTo(ScreenRoutes.AuthGraph.route) {
                            inclusive = true
                        }
                    }
                }
            }
            composable(route = ScreenRoutes.SignUp.route) {
                SignupScreen(modifier) {
                    navController.navigate(ScreenRoutes.Credentials.route)
                }
            }
            composable(route = ScreenRoutes.Credentials.route) {
                CredentialsScreen(modifier) {
                    navController.navigate(ScreenRoutes.Login.route)
                }
            }
        }
        navigation(
            startDestination = ScreenRoutes.Home.route,
            route = ScreenRoutes.HomeGraph.route
        ) {
            composable(route = ScreenRoutes.Home.route) {
                HomeScreen(modifier) {
                    navController.navigate(ScreenRoutes.Profile.route)
                }
            }
            composable(route = ScreenRoutes.Profile.route) {
                ProfileScreen(modifier) {
                    navController.navigate(ScreenRoutes.Logout.route)
                }
            }
            composable(route = ScreenRoutes.Logout.route) {
                LogoutScreen(modifier) {
                    navController.navigate(ScreenRoutes.Login.route) {
                        popUpTo(ScreenRoutes.HomeGraph.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
}