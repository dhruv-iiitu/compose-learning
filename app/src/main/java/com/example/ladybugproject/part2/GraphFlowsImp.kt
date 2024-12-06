package com.example.ladybugproject.part2

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ladybugproject.activityWithGenericNavGraph.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
class FirstGraphFlow(
    override val startDestination: String = "start"
) : GraphFlow {
    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(startDestination) { Screen("Screen 1") }
        navGraphBuilder.composable("details") { Screen("Screen 2") }
    }
}

@Parcelize
class SecondGraphFlow(override val startDestination: String = "start") : GraphFlow {

    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable("start") { Screen("Screen A") }
        navGraphBuilder.composable("settings") { Screen("Screen B") }
    }
}