package com.example.ladybugproject.part2

import android.os.Parcelable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface GraphFlow : Parcelable {
    val startDestination: String
    fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavController)
}
