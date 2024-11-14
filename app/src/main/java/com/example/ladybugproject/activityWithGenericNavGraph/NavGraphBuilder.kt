package com.example.ladybugproject.activityWithGenericNavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface NavGraphBuilder<T> {
    @Composable
    fun BuildGraph(navController: NavHostController)
}
