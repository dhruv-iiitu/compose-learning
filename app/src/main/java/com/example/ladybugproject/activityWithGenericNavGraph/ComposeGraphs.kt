package com.example.ladybugproject.activityWithGenericNavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class FlowOneNavGraph : NavGraphBuilder<FlowOneNavGraph> {
    @Composable
    override fun BuildGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1") { Screen("Screen 1") }
            composable("screen2") { Screen("Screen 2") }
        }
    }
}

class FlowTwoNavGraph : NavGraphBuilder<FlowTwoNavGraph> {
    @Composable
    override fun BuildGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "screenA") {
            composable("screenA") { Screen("Screen A") }
            composable("screenB") { Screen("Screen B") }
        }
    }
}
